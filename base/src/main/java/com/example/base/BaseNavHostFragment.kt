package com.example.base

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment

class BaseNavHostFragment : NavHostFragment() {
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        val fragments = childFragmentManager.fragments
        for (fragment in fragments) {
            // Propagate visibility change
            childFragmentManager.fragments[0].onHiddenChanged(hidden)
        }
    }

    companion object {
        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"
        private const val KEY_START_DESTINATION_ARGS =
            "android-support-nav:fragment:startDestinationArgs"

        @JvmOverloads
        fun create(
            @NavigationRes graphResId: Int,
            startDestinationArgs: Bundle? = null
        ): BaseNavHostFragment {
            var b: Bundle? = null
            if (graphResId != 0) {
                b = Bundle()
                b.putInt(KEY_GRAPH_ID, graphResId)
            }
            if (startDestinationArgs != null) {
                if (b == null) {
                    b = Bundle()
                }
                b.putBundle(KEY_START_DESTINATION_ARGS, startDestinationArgs)
            }
            val result = BaseNavHostFragment()
            if (b != null) {
                result.arguments = b
            }
            return result
        }
    }
}