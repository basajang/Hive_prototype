package com.waem.hivePrototype.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.R;

import org.jetbrains.annotations.NotNull;



public class CustomDialog {

	private String message,positiveBtnText,negativeBtnText,oripositiveBtnText;
	private int defaultTime = 0;

	private DialogListener dialogListener;
	private View view;
	private Dialog dialog;
	private Context context;
	private Handler handler;
	private Runnable runnable;


	private Button btnDialogPositive,btnDialogNegative;
	private TextView tvDialogMessage;


	public CustomDialog(Context context){
		this.context = context;
	}


	public void CustomDialog(Context context, @NotNull String message,String positiveBtnText,String negativeBtnText, int defaultTime){

		this.context = context;
		this.message = message;

		if(positiveBtnText != null){
			this.positiveBtnText = positiveBtnText;
		}
		if(negativeBtnText != null){
			this.negativeBtnText = negativeBtnText;
		}
		if(defaultTime != 0){
			this.defaultTime = defaultTime;
		}

	}

	public void buildDialog(){

		if(view != null){

			btnDialogPositive = view.findViewById(R.id.btn_dialog_positive);
			btnDialogNegative = view.findViewById(R.id.btn_dialog_negative);
			tvDialogMessage = view.findViewById(R.id.tv_dialog_message);

			if(defaultTime >= 0){
				message = message+"("+defaultTime+")";
			}

			tvDialogMessage.setText(message);

			if(positiveBtnText == null){
				oripositiveBtnText = btnDialogPositive.getText().toString();
				positiveBtnText = oripositiveBtnText;
			}
			if(positiveBtnText != null){
				btnDialogPositive.setText(positiveBtnText);
				positiveBtnText = oripositiveBtnText;
			}
			if(negativeBtnText != null){
				btnDialogNegative.setText(negativeBtnText);
			}

			btnDialogPositive.setOnClickListener(view -> {
				if(dialogListener != null ){
					if(handler != null){
						handler.removeCallbacks(runnable);
					}

					dialogListener.onPositiveClick();
					dismissDialog();
				}
			});

			btnDialogNegative.setOnClickListener(view -> {
				if(dialogListener != null){
					if(handler != null){
						handler.removeCallbacks(runnable);
					}

					dialogListener.onNegativeClick();
					dismissDialog();
				}
			});
		}
		startHandler();
	}
	public void show(){
		view = View.inflate(context,R.layout.custom_dialog,null);
		dialog = new Dialog(context);
		handler = new Handler();

		buildDialog();
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// dialog 타이틀 숨기기
		dialog.setTitle("");
		dialog.setContentView(view);
		dialog.setCancelable(false);//dialog 띄운 후 뒤로가기 키나 dialog 바깥 터치해도 dialog 안사라지도록함


		dialog.show();
	}

	private void startHandler(){
		if(defaultTime >= 0){
			runnable =new Runnable() {
				@Override
				public void run() {
					setDefaultTime(defaultTime -1);
					if(defaultTime <= -1){
						dialog.dismiss();
						handler.removeCallbacks(this);
					}else {
						buildDialog();
					}
				}
			};
			if(handler != null){
				Log.d(GlobalConst.TAG, "startHandler: "+defaultTime);
				handler.postDelayed(runnable,1000);
			}
		}
	}

	public CustomDialog setMessage(String message){
		this.message = message;
		return this;
	}

	public CustomDialog setPositiveBtnText(String positiveBtnText){
		this.positiveBtnText = positiveBtnText;
		return this;
	}

	public CustomDialog setNegativeBtnText(String negativeBtnText){
		this.negativeBtnText = negativeBtnText;
		return this;
	}

	public CustomDialog setDefaultTime(int defaultTime) {
		this.defaultTime = defaultTime;
		return this;
	}

	public CustomDialog setOnDialogListener(DialogListener listener) {
		this.dialogListener = listener;
		return this;
	}

	public void dismissDialog(){
		if(dialog != null){
			dialog.dismiss();
		}
	}

	public interface DialogListener {
		public abstract void onPositiveClick();

		public abstract void onNegativeClick();
	}

}

		
	


