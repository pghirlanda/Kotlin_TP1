package fr.estia.net.ghirlanda.p.neighbors

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface NavigationListener {
    fun showFragment(fragment: Fragment)
    fun updateTitle(@StringRes title: Int)
}
