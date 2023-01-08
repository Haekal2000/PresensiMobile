//package com.example.aplikasipresensi.model.course
//
//class TestingJava : AppCompatActivity(), ZXingScannerView.ResultHandler {
//    //Inisialisasi ZXingScannerView
//    private var mScannerView: ZXingScannerView? = null
//
//    //Inisialisasi kelas database
//    private var db: Database? = null
//    protected fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mScannerView = ZXingScannerView(this)
//        setContentView(mScannerView)
//        setTitle("Scan")
//
//        //Inisialisasi kelas database
//        db = Database(this)
//
//        //Star Kamera
//        mScannerView.startCamera(0) // 0 Kamera Belakang dan 1 itu kemera depan
//    }
//
//    fun onStart() {
//        super.onStart()
//        mScannerView.setResultHandler(this)
//        mScannerView.startCamera(0) // 0 Kamera Belakang dan 1 itu kemera depan
//        doRequestPermission()
//    }
//
//    private fun doRequestPermission() {
//        val permissionCheckStorage: Int =
//            ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (permissionCheckStorage == PackageManager.PERMISSION_DENIED) {
//                requestPermissions(
//                    arrayOf<String>(
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_EXTERNAL_STORAGE
//                    ), 100
//                )
//            }
//        }
//    }
//
//    fun onResume() {
//        super.onResume()
//        mScannerView.setResultHandler(this)
//        mScannerView.startCamera(0) // 0 Kamera Belakang dan 1 itu kemera depan
//    }
//
//    fun onPause() {
//        super.onPause()
//        mScannerView.stopCamera()
//    }
//
//    fun handleResult(rawResult: com.google.zxing.Result) {
//
////        Log.v("TAG 1 ", rawResult.getText());
////        Log.v("TAG 2", rawResult.getBarcodeFormat().toString());
//
//        //9498375sdf-fdd-dfgdfg987479-dfgdfg
//        val uid: String = UUID.randomUUID().toString()
//        val hasil: String = rawResult.getText() //12345#NAMA
//        val tokens = StringTokenizer(hasil, "#") //Untuk memecahkan sebelum pagar
//
//        //Mengambil NOMOR INDUK
//        val npak: String = tokens.nextToken() //12345
//        val nama: String = tokens.nextToken() //NAMA
//
//        //Menghasilkan tanggal dengan format 17-09-2021
//        val tanggal: String = SimpleDateFormat("d-MM-yyyy", Locale.getDefault()).format(Date())
//
//        //Menghasilkan tanggal dengan format 15:47:00
//        val jam: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
//
//        //Tujuan untuk menampilkan hasil Log
//        Log.v("SIMPAN INI", uid + npak + nama + tanggal + jam)
//
//        //Data absensi akan di cek terlebih dahulu
//        val cekSimpan: Boolean = db.TambahData(uid, npak, nama, tanggal, jam, "Hadir", "Tidak")
//        if (cekSimpan) {
//
//            //Prosedure simpan data di cloud
//            absen(uid, npak, nama, tanggal, jam)
//
//            //untuk memunculkan notifikasi bawha simpan berhasil
//            Toast.makeText(this@ScanActivity, "Absen berhasil.", Toast.LENGTH_LONG).show()
//            onResume()
//        } else {
//
//            //untuk memunculkan notifikasi bawha gagal disimpan
//            Toast.makeText(this@ScanActivity, "Anda sudah absen!", Toast.LENGTH_LONG).show()
//            onResume()
//        }
//        onResume()
//    }
//
//    //Prosedure simpan data di cloud
//    private fun absen(uid: String, nidn: String, nama: String, tanggal: String, jam: String) {
//
//        //progress dialog muncul
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Proses absensi...")
//        progressDialog.show()
//
//        //building retrofit object
//        val retrofit: Retrofit = Builder()
//            .baseUrl(Apiurl.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        //Defining retrofit api service
//        val service: Apiservice = retrofit.create(Apiservice::class.java)
//
//        //defining the call
//        val call: Call<Result> =
//            service.simpanDataCloud(Apiurl.API_KEY, uid, nidn, nama, tanggal, jam, "1", "0")
//
//        //calling the api
//        call.enqueue(object : Callback<Result?>() {
//            fun onResponse(call: Call<Result?>?, response: Response<Result?>) {
//                //menutup progress dialog
//                progressDialog.dismiss()
//                assert(response.body() != null)
//                val error: Boolean = response.body().getError()
//                val message: String = response.body().getPesan()
//                if (!error) {
//
//                    //displaying the message from the response as toast
//                    Toast.makeText(getApplicationContext(), "Terima Kasih!", Toast.LENGTH_LONG)
//                        .show()
//                } else {
//
//                    //displaying the message from the response as toast
//                    Toast.makeText(getApplicationContext(), "Akses diterima!", Toast.LENGTH_LONG)
//                        .show()
//                }
//                onResume()
//            }
//
//            fun onFailure(call: Call<Result?>?, t: Throwable?) {
//                progressDialog.dismiss()
//                Toast.makeText(
//                    getApplicationContext(),
//                    "Koneksi internet bermasalah.",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        })
//    }
//}