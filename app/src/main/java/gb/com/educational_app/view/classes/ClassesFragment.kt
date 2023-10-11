package gb.com.educational_app.view.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import gb.com.educational_app.databinding.FragmentClassesBinding

class ClassesFragment : Fragment() {

    private var _binding: FragmentClassesBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ClassesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}