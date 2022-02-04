package kr.co.calculator;

/*
    아래처럼 수정하시오.
    1) 터치를 클릭으로 변경
    2) 나머지 값을 구하는 버튼을 추가
    3) 값을 입력하지 않고 버튼 클릭 시 오류 메세지를 토스트 메세지로 나타냄
    4) 실수값을 계산함
    5) 0으로 나누면 토스트 메세지를 나타내고 계산하지 않음
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;  // 입력될 2개 문자열을 저장할 변수
    Double result;      // 계산 결과를 저장할 실수 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 액티비티 화면 설정하는 메서드, XML 파일과 코드와의 연결
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("간단한 계산기");

        edit1 = findViewById(R.id.Edit1);       // 에딧텍스트를 변수에 대입
        edit2 = findViewById(R.id.Edit2);

        btnAdd = findViewById(R.id.BtnAdd);     // 버튼을 변수에 대입
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRem = findViewById(R.id.BtnRem);

        textResult = findViewById(R.id.TextResult);     // 텍스트뷰를 변수에 대입

        // 더하기 버튼 클릭했을 때 동작 -> 버튼에 터치 이벤트 리스너 정의
        // - > 터치 시에 동작하는 내용을 onTouch() 메서드 안에 코딩함
        btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               num1 = edit1.getText().toString();
               num2 = edit2.getText().toString();

               // 값이 비어있다면
               if(num1.trim().equals("") || num2.trim().equals("")) {
                   Toast.makeText(getApplicationContext(), "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show();

               } else {
                   result = Double.parseDouble(num1) + Double.parseDouble(num2);
                   textResult.setText("계산 결과 : " + result.toString());
               }
           }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               num1 = edit1.getText().toString();
               num2 = edit2.getText().toString();

               // 값이 비어있다면
               if(num1.trim().equals("") || num2.trim().equals("")) {
                   Toast.makeText(getApplicationContext(), "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show();

               } else {
                   result = Double.parseDouble(num1) - Double.parseDouble(num2);
                   textResult.setText("계산 결과 : " + result.toString());
               }
           }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show();

                } else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show();

                } else {
                    // num2가 0이면 나누지 않음
                    if (num2.trim().equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();

                    } else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        result = (result * 10) / 10.0;      // 소수점 아래 1자리까지만 출력
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                // 값이 비어있다면
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력값이 비어있습니다.", Toast.LENGTH_SHORT).show();

                } else {
                    // num2가 0이면 나누지 않음
                    if (num2.trim().equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();

                    } else {
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });
    }
}