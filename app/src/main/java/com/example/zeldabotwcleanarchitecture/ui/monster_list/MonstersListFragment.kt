package com.example.zeldabotwcleanarchitecture.ui.monster_list

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.ContentInfo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zeldabotwcleanarchitecture.databinding.FragmentMonstersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonstersListFragment : Fragment(), MonsterListAdapter.OnClickCallBack {

    private lateinit var binding: FragmentMonstersListBinding
    private val viewModel: MonsterListViewModel by viewModels()
    private lateinit var adapterMonster: MonsterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMonstersListBinding.inflate(layoutInflater)

        adapterMonster = MonsterListAdapter(requireContext(), this)

        binding.listMonster.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterMonster
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { state ->


            if (state.isLoading){
                binding.progressCircle.visibility = View.VISIBLE
                binding.listMonster.visibility = View.GONE
            } else {
                Log.e("blop", state.monsters.get(0).toString())
                adapterMonster.addMonster(state.monsters)
                binding.progressCircle.visibility = View.GONE
                binding.listMonster.visibility = View.VISIBLE
            }

            if (state.error.isNotBlank()) {
                binding.listMonster.visibility = View.GONE
                Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun detailMonster(monsterId: Int) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(requireContext())
        sharedPref.edit()
            .putInt("MONSTER_ID", monsterId)
            .apply()
        val action = MonstersListFragmentDirections.actionMonstersListFragmentToMonsterDetailFragment()
        findNavController().navigate(action)
    }

}