package com.masoud.cleanarchitecture.presentation.ui.fragment.notification

import com.masoud.cleanarchitecture.databinding.NotificationFragmentBinding
import com.masoud.cleanarchitecture.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<NotificationFragmentBinding>() {
    override fun setBinding(): NotificationFragmentBinding = NotificationFragmentBinding.inflate(layoutInflater)
}