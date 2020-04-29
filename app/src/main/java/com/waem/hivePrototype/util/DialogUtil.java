package com.waem.hivePrototype.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil {

	private Context context;

	public DialogUtil(){

	}


	public void Dia(){

		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setTitle("삭제 확인"); builder.setMessage("삭제하시겠습니까?");

		builder.setNegativeButton("예", new DialogInterface.OnClickListener() {

			@Override 
			public void onClick(DialogInterface dialog, int which) { 
				//예 눌렀을때의 이벤트 처리

				} 
		});

		builder.setPositiveButton("아니오", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//아니오 눌렀을때의 이벤트 처리
				}

		}); 
		builder.show();

	}

	public Context getContext() {
		return context;
	}
}

		
	


