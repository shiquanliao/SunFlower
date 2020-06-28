package com.android.sunflower

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.sunflower.utilities.InjectorUtils
import com.android.sunflower.viewmodels.PlantListViewModel

class PlantListFragment : Fragment() {

    private val viewModel: PlantListViewModel by viewModels {
    }


}
