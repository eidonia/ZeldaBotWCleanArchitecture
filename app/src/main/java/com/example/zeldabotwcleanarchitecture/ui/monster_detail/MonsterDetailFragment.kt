package com.example.zeldabotwcleanarchitecture.ui.monster_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.zeldabotwcleanarchitecture.R
import com.example.zeldabotwcleanarchitecture.databinding.FragmentMonsterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonsterDetailFragment : Fragment() {

    private lateinit var binding: FragmentMonsterDetailBinding
    private val viewModel: MonsterDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMonsterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { state ->

            state.monster?.let { monster ->
                with(binding) {
                    progressCircle.visibility = View.GONE
                    imgMonster.apply {
                        visibility = View.VISIBLE
                        Glide.with(context)
                            .load(monster.image)
                            .into(this)
                    }

                    txtDescriptionMonster.apply {
                        visibility = View.VISIBLE
                        text = monster.description
                    }

                    txtNameMonster.apply {
                        visibility = View.VISIBLE
                        text = monster.name
                    }
                }
            }

            if (state.isLoading){
                binding.progressCircle.visibility = View.VISIBLE
                binding.imgMonster.visibility = View.GONE
                binding.txtDescriptionMonster.visibility = View.GONE
                binding.txtNameMonster.visibility = View.GONE
            }

            if (state.error.isNotBlank()) {
                binding.imgMonster.visibility = View.GONE
                binding.txtDescriptionMonster.visibility = View.GONE
                binding.txtNameMonster.visibility = View.GONE
                Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
            }
        }
    }

}