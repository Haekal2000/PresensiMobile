package com.example.aplikasipresensi.ui.home.views

import android.app.AlertDialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.adapter.CourseAdapter
import com.example.aplikasipresensi.adapter.CourseAdapterTesting
import com.example.aplikasipresensi.api.AcceptCourseApi
import com.example.aplikasipresensi.api.ClosingCourseApi
import com.example.aplikasipresensi.api.CourseApi
import com.example.aplikasipresensi.base.BaseFragment
import com.example.aplikasipresensi.databinding.FragmentStudentBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.CourseModel
import com.example.aplikasipresensi.network.RemoteDataSource
import com.example.aplikasipresensi.network.Resource
import com.example.aplikasipresensi.preferences.DataPreferences
import com.example.aplikasipresensi.repository.AcceptCourseRepository
import com.example.aplikasipresensi.repository.ClosingCourseRepository
import com.example.aplikasipresensi.repository.CourseRepository
import com.example.aplikasipresensi.requests.AcceptCourseRequest
import com.example.aplikasipresensi.requests.ClosingCourseRequest
import com.example.aplikasipresensi.ui.home.viewmodel.AcceptCourseViewModel
import com.example.aplikasipresensi.ui.home.viewmodel.ClosingCourseViewModel
import com.example.aplikasipresensi.ui.home.viewmodel.CourseViewModel
import com.example.aplikasipresensi.util.CORE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class StudentFragment : BaseFragment<FragmentStudentBinding>() {
    private lateinit var courseAdapter: CourseAdapter
    private lateinit var courseAdapterTesting: CourseAdapterTesting
    private lateinit var listCourse: MutableList<CourseModel>
    lateinit var viewModelCourse: CourseViewModel
    lateinit var viewModelAcceptCourse: AcceptCourseViewModel
    lateinit var viewModelClosingCourse: ClosingCourseViewModel
    val courseLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

//    companion object {
//        private lateinit var studentFragment: StudentFragment
//
//        fun newInstance() : StudentFragment {
//            studentFragment = StudentFragment()
//            return studentFragment
//        }
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        listCourse = ArrayList()
//        courseAdapter = CourseAdapter(listCourse)
//        courseAdapter = CourseAdapter(mutableListOf())
//        courseAdapter.setItemDataListener(object : CourseAdapter.ItemDataListener {
//            override fun itemDataClicked(course: CourseModel) {
//                goToActivity(AttendanceDetailActivity::class.java, bundle = null, false)
//            }
//        })
        setInit()
        initView()
        initAction()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        bind = FragmentStudentBinding.inflate(inflater, container, false)
//        remoteDataSource = RemoteDataSource(requireActivity())
//        prefs = DataPreferences(requireActivity())
//
//        val courseRepo = CourseRepository(remoteDataSource.buildApi(CourseApi::class.java, CORE_BASE_URL))
//        viewModelCourse = CourseViewModel(courseRepo)
//
//        prefs.getNrpId.asLiveData().observe(requireActivity(), Observer {
//            bind.tvUserNrp.text = it
//        })
//
//        bind.rvCourse.layoutManager = courseLayoutManager
//        bind.rvCourse.clipChildren = false
//        courseAdapter = CourseAdapter(listCourse)
//        bind.rvCourse.adapter = courseAdapter
//        viewModelCourse.getListCourse("46c0d3ec-0063-4f26-8f14-6be3bbe99f07", "28104643-57bb-466b-9a68-091f3322c450")
//        Log.e("LISSTTTT", viewModelCourse.getListCourse("46c0d3ec-0063-4f26-8f14-6be3bbe99f07", "28104643-57bb-466b-9a68-091f3322c450").toString())
//        viewModelCourse.courseResponse.observe(requireActivity()) {
//            when(it) {
//                is Resource.Success -> {
//                    it.value.data?.let { it1 ->  courseAdapter.setCourse(it1)}
////                    courseAdapter.setCourse(it.value.data!!)
//                    Snackbar.make(bind.llStudentFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
//                }
//                is Resource.Failure -> {
//                    Log.e("rv GAGAL", it.toString())
//                    Snackbar.make(bind.llStudentFragment, "rv gagal", Snackbar.LENGTH_LONG).show()
//
//                }
//            }
//        }
//
//        courseAdapter.setOnSelectedListener(object : OnItemClickListener{
//            override fun onItemClick(itemView: View, position: Int) {
//                var bundle = Bundle()
//                bundle.putString("courses", courseAdapter.getCourse().get(position).name)
//                goToActivity(AttendanceDetailActivity::class.java, bundle, false)
//            }
//
//            override fun onItemLongClick(itemView: View, position: Int): Boolean {
//                return true
//            }
//
//        })
//        return bind.root
//    }


    fun setInit() {
        val courseRepo = CourseRepository(remoteDataSource.buildApi(CourseApi::class.java, CORE_BASE_URL))
        viewModelCourse = CourseViewModel(courseRepo)

        val acceptCourse = AcceptCourseRepository(remoteDataSource.buildApi(AcceptCourseApi::class.java,
            CORE_BASE_URL))
        viewModelAcceptCourse = AcceptCourseViewModel(acceptCourse)

        val closingCourseRepo = ClosingCourseRepository(remoteDataSource.buildApi(ClosingCourseApi::class.java, CORE_BASE_URL))
        viewModelClosingCourse = ClosingCourseViewModel(closingCourseRepo)
    }

    fun initView() {
        prefs.getNrpId.asLiveData().observe(requireActivity(), Observer {
            bind.tvUserNrp.text = it
        })

        bind.rvCourse.layoutManager = courseLayoutManager
        bind.rvCourse.clipChildren = false
        bind.rvCourse.clipToPadding = false
        courseAdapterTesting = CourseAdapterTesting(requireContext())
        bind.rvCourse.adapter = courseAdapterTesting
        viewModelCourse.getListCourse(runBlocking { prefs.getDepartmentId.first() }, runBlocking { prefs.getAcademicPeriodId.first() }, runBlocking { prefs.getNrpId.first() })
        viewModelCourse.courseResponse.observe(requireActivity()) {
            when(it) {
                is Resource.Success -> {
                    it.value.data?.let { it1 ->  courseAdapterTesting.setCourse(it1)}
                    Snackbar.make(bind.llStudentFragment, "rv muncul", Snackbar.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Log.e("rv GAGAL", it.toString())
                    Snackbar.make(bind.llStudentFragment, "rv gagal", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    fun initAction() {
        courseAdapterTesting.setOnSelectedListener(object : OnItemClickListener{
            override fun onItemClick(itemView: View, position: Int) {
                val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.input_course_code, null)
                val mBuilder = AlertDialog.Builder(requireContext())
                    .setView(mDialogView)
                    .setTitle("Class Code")
                val mAlertDialog = mBuilder.show()
                mDialogView.findViewById<Button>(R.id.btn_submit).setOnClickListener {
                    var requestCourse = AcceptCourseRequest()
                    requestCourse.courseCode = "1cb3139a0032"
                    Log.e("cek ketikan", mAlertDialog.findViewById<EditText>(R.id.et_course_code).toString())
                    requestCourse.studentId = runBlocking { prefs.getNrpId.first() }
                    requestCourse.lecturerNik = "710071"
                    requestCourse.scheduleId = "uVvpM"
                    requestCourse.isPresent = true
                    requestCourse.isDone = false
                    viewModelAcceptCourse.acceptCourse(requestCourse)
                    viewModelAcceptCourse.acceptCourseResponse.observe(requireActivity()) {
                        when (it) {
                            is Resource.Success -> {
                                Snackbar.make(bind.llStudentFragment, "Course Code Cocok!!!", Snackbar.LENGTH_LONG).show()
                                mAlertDialog.dismiss()
                                var requestClosing = ClosingCourseRequest()
                                requestClosing.lecturerNik = "710071"
                                requestClosing.courseId = "IN212"
                                requestClosing.scheduleId = "YIzVZ"
                                requestClosing.isComplete = true
                                viewModelClosingCourse.getClosingCourse(requestClosing)
                                goToActivity(AttendanceDetailActivity::class.java, null, true)
                            }
                            is Resource.Failure -> {
                                Log.e("gagal euy", it.toString())
                                mAlertDialog.findViewById<TextInputLayout>(R.id.til_course_code).error = "Course Code Salah!!!"
                            }
                        }
                    }
                }
//                var bundle = Bundle()
//                bundle.putString("courses", courseAdapterTesting.getCourse().get(position).name)
//                goToActivity(AttendanceDetailActivity::class.java, bundle, false)
            }

            override fun onItemLongClick(itemView: View, position: Int): Boolean {
                return true
            }

        })
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentStudentBinding.inflate(inflater,container, false)
}