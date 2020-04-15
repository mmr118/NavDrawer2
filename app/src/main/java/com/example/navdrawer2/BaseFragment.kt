package com.example.navdrawer2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM_TITLE = "title"
private const val ARG_PARAM_VIEW_COLOR = "viewColor"
private const val ARG_PARAM_TEXT_COLOR = "textColor"

/**
 * A simple [Fragment] subclass.
 * Use the [BaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BaseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String = "UNKNOWN"
    private var viewColor: Int = Color.LTGRAY
    private var textColor: Int = Color.DKGRAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM_TITLE) ?: "UNKNOWN"
            viewColor = it.getInt(ARG_PARAM_VIEW_COLOR) ?: Color.LTGRAY
            textColor = it.getInt(ARG_PARAM_TEXT_COLOR) ?: Color.DKGRAY
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        container?.setBackgroundColor(viewColor)

        var textView = view?.findViewById<TextView>(R.id.textView)
        textView?.setTextColor(textColor)
        textView?.setBackgroundColor(viewColor)

        if (textView == null) {

            print("Issue")

        }

        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param title The title of the selected menu item.
         * @param viewColor The color for the fragment's view.
         * @param textColor The color for the displayed text.
         * @return A new instance of fragment BaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(title: String, viewColor: Int, textColor: Int) =
            BaseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_TITLE, title)
                    putInt(ARG_PARAM_VIEW_COLOR, viewColor)
                    putInt(ARG_PARAM_TEXT_COLOR, textColor)
                }
            }
    }
}
