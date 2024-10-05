package com.laioffer.spotify.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.laioffer.spotify.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val frameLayout = FrameLayout(requireContext())
//        val textView = TextView(requireContext())
//        textView.text = "Home"
//        frameLayout.addView(textView)
//        return inflater.inflate(R.layout.fragment_home, container, false)
//        val composeView  = ComposeView(requireContext())
//        composeView.setContent {
//            MaterialTheme(colors = darkColors()) {
//                HomeScreen(viewModel)
//            }
//        }
//        return composeView
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme(colors = darkColors()) {
                    HomeScreen(viewModel, onTap = {
                        Log.d("HomeFragment", "We tapped ${it.name}")
                        val direction = HomeFragmentDirections.actionHomeFragmentToPlaylistFragment(it)
                        findNavController().navigate(direction)
                    })
                }
            }
        }
//        return frameLayout
    }

    // similar React useEffect
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.uiState.value.isLoading) {
            viewModel.fetchHomeScreen()
        }
    }
}