package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.Constant.Constant;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 实名认证页面
 */
public class RealNameActivity extends BaseActivity {

    @BindView(R.id.information_btn_comit)
    Button btn_comit;
    @BindView(R.id.real_iv_heard)
    CircleImageView iv_heard;
    /**
     * 创建一个以当前时间为名称的文件
     */
    private File tempFile = null;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_infromation);
    }

    @Override
    protected void findViewById() {
        btn_comit = (Button) findViewById(R.id.information_btn_comit);
        iv_heard = (CircleImageView) findViewById(R.id.real_iv_heard);

    }

    @Override
    protected void setListener() {
        btn_comit.setOnClickListener(this);
        iv_heard.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.real_name);

    }

    @Override
    protected void processLogic() {
        tempFile = new File(Environment.getExternalStorageDirectory(), getPhotoFileName());


    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = null;
        switch (v.getId()) {
            case R.id.information_btn_comit:
                mIntent = new Intent(this, ChusNumberActivity.class);
                startActivity(mIntent);
                break;
            case R.id.real_iv_heard:
//                startChoose();
                break;

        }

    }

    /**
     * 添加头像图片
     */
    private void startChoose() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.my_set_photo)
                .setPositiveButton(R.string.my_photo, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 调用系统的拍照功能
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        // 指定调用相机拍照后照片的储存路径
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                        startActivityForResult(intent, Constant.PHOTO_REQUEST_TAKE_PHOTO);
                    }
                })
                .setNegativeButton(R.string.my_set_album, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_PICK, null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(intent, Constant.PHOTO_REQUEST_GALLERY);
                    }
                })
                .create()
                .show();
    }

    /**
     * 使用系统当前日期加以调整作为照片的名称
     *
     * @return 照片的名称
     */
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss", Locale.getDefault());
        return dateFormat.format(date) + ".jpg";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.PHOTO_REQUEST_TAKE_PHOTO:
                startPhotoZoom(Uri.fromFile(tempFile), 200);
                break;

            case Constant.PHOTO_REQUEST_GALLERY:
                if (data != null) {
                    startPhotoZoom(data.getData(), 200);
                } else {
                    Log.e("ima", "没有返回图片");
                }
                break;
            case Constant.PHOTO_REQUEST_CUT:
                Bundle bundle = null;
                if (data != null) {
                    bundle = data.getExtras();
                }
                if (bundle != null) {
                    File tempFile1;
                    getPhotoFileName();
                    Bitmap photo = bundle.getParcelable("data");
                    try {
                        //保存裁剪后的数据并压缩
                        tempFile1 = new File(Environment.getExternalStorageDirectory(), getPhotoFileName());
                        FileOutputStream fos = new FileOutputStream(tempFile1);
                        if (photo != null) {
                            photo.compress(Bitmap.CompressFormat.JPEG, 99, fos);
                        }
//                        commitPic(tempFile1);
                    } catch (FileNotFoundException e) {
                        // bugly会将这个throwable上报
                        e.printStackTrace();
                    }
                }
                break;
//            case Constant.RESULT_Account_center:
//                String name = data.getExtras().getString("name");
//                Log.i("name", name);
//                //                userName.setText(name);
//                break;
            //未登录时重新请求数据
        }
    }

    /**
     * 转到裁剪缩放页面
     *
     * @param uri  图片Uri
     * @param size 目标宽高
     */
    private void startPhotoZoom(Uri uri, int size) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", size);
        intent.putExtra("outputY", size);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, Constant.PHOTO_REQUEST_CUT);
    }
}
