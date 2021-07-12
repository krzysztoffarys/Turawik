package com.crys.turawik.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.crys.turawik.R
import com.crys.turawik.databinding.CalculatorProductFragmentBinding
import com.crys.turawik.viewmodels.FragmentCalculatorProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlin.math.roundToInt

class FragmentCalculatorProduct : Fragment(R.layout.calculator_product_fragment) {

    private lateinit var binding: CalculatorProductFragmentBinding
    private val model: FragmentCalculatorProductViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CalculatorProductFragmentBinding.bind(view)

        val productObserver = Observer<String> { newPrice ->
            binding.tvResult.text = newPrice
        }
        model.currentPrice.observe(viewLifecycleOwner, productObserver)

        binding.btnAdd.setOnClickListener {
            if (binding.etMargin.text.isNullOrBlank() || binding.etPrice.text.isNullOrBlank()) {
                return@setOnClickListener
            }
            val margin = binding.etMargin.text.toString().toDouble()
            val prdouctPrice = binding.etPrice.text.toString().toDouble()
            val vat = binding.spinnerProduct.selectedItem.toString().toDouble() / 100 + 1
            val result = (margin * prdouctPrice * vat * 100).roundToInt().toDouble() / 100
            model.currentPrice.value = result.toString()
        }
    }

}