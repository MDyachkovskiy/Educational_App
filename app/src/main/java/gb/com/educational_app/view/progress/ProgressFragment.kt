package gb.com.educational_app.view.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import gb.com.educational_app.databinding.FragmentProgressBinding

class ProgressFragment: Fragment() {
    private var _binding : FragmentProgressBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProgressFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}