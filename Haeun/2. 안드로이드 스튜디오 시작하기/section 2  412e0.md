# section 2 : 안드로이드 스튜디오 시작하기

### 패키지명

- 3가지 키워드를 .으로 구분해서 이름 짓기 (ex. `com.example.myfirstapp`)
- 앱을 배포하려면 고유한 패키지명이 있어야함 (그래야 안드로이드 플레이 스토어에서 승인해줌)
- 소문자로 이루어져있어야함

### SDK

- Software Development Kit
- 소프트웨어 개발 도구 + 설치 패키지의 모음
- 컴파일러, 디버거, 소프트에어 프레임워크로 앱을 구현하게 해줌
- 하드웨어 플랫폼과 운영체제에 연결되어있음 (⇒ 안드로이드 앱)
- Minimum SDK 는 기본적으로 API21: Android 5.0 (Lollipop) 선택

### appcompat

- [ ]  android developers 코드랩 복습하기

### Use legacy android support libraries

- 하위 호환성 고려 : 신규 OS 에 추가된 신규 API 를 사용하게되면, 이전 OS가 설치된 안드로이드 기기에서는 해당 API 를 사용할 수 없음. 이럴때 android.support library 를 사용하면, 신규 OS와 이전 OS 모두에서 정상동작 가능하게 support 해줌. (초보 개발이라면 굳이 추가안해도 됨)

### Gradle

- 오픈 소스 빌드 도구
- build.gradle : 빌드 스크립트, 빌드 구성 스크립트, 의존성이나 플러그인 설정 등과 같은 빌드에 필요한 설정을 함.

[Gradle이란 무엇일까?](https://madplay.github.io/post/what-is-gradle)

[Gradle이란 무엇인가?? Gradle 간단 정리!](https://willbesoon.tistory.com/93)

### 개발 선언 창 : ctrl키 누르고 해당 키워드 클릭

### setContentView

- `setContentView(R.layout.activity_main)`
- R.layout.activity_main 파일을 찾아서 뷰의 컨텐트로 넣어달라는 코드
- 화면에 사용될 파일이 activity_main 이라는 의미
- R : resources,  res 폴더 (generated 안붙어있는 것)

### sp : scale independent pixel

- 어떤 장치를 사용하든지 비슷한 크기로 표시해줌
- 스크린에 따라 글씨가 비슷하게 보임
- 장치의 스크린이 커지면 글씨가 작아보이는게 아니라 스크린 대비 글씨 크기가 비슷함

### id

- ui의 모든 아이템에는 아이디가 있음
- 설정 가능
- 실제 코드에서 ui 요소에 접근 가능

### 사람 수 세기 앱

- constraint layout에서 통제 건 후에 간격 조정하기
    - 기준점 조정하기
    - 기준점 그대로 + 간격에 픽셀 추가하기
- String → Int : toInt() 함수 사용
- [ ]  onCreate 함수는 액티비티 생성시 실행됨, 전체 생명주기동안 한번만 실행되는 시작 로직을 실행 → onCrate 안에 clickListener을 넣는 이유는...? 클릭이벤트가 발생할 때마다 감지할 수 있는 이유가 뭘까?

---

```kotlin
//btn_click_me.setOnClickListener()
var people_num = tv_people_num.text.toString().toInt()
tv_people_num.setText(people_num)
//제대로 실행 안된 이유 : Exception 발생 
```

```kotlin
//btn_click_me.setOnClickListener()
people_num = tv_people_num.text.toString().toInt()
            //println(++people_num)
            people_num++
            tv_people_num.text = people_num.toString()
```

---

```kotlin
val btn_click_me : Button = findViewById(R.id.btn_click_me)
        val tv_people_num : TextView = findViewById(R.id.tv_people_num)
        var people_num = 0

        btn_click_me.setOnClickListener()
        {
            people_num++
            tv_people_num.text = people_num.toString()
        
        }
```

- Toast  : `Toast.makeText(context, text, length).show()`
    - context : 토스트가 출력될 컨텍스트
    - text : 메시지 내용
    - length : 출력할 시간
        - `Toast.LENGTH_LONG` : 3.5초
        - `Toast.LENGTH_SHORT` : 2초

- activity_main.xml
    
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    
        <Button
            android:id="@+id/btn_click_me"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="CLICK ME"
            app:layout_constraintBottom_toTopOf="@+id/tv_people_num"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.8" />
    
        <TextView
            android:id="@+id/tv_people_num"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0"
            android:textSize="24sp"
            android:textStyle="bold"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    
    </androidx.constraintlayout.widget.ConstraintLayout>
    ```
    

- MainActivity.kt
    
    ```kotlin
    package com.example.myapplication0218
    
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import android.widget.TextView
    import android.widget.Toast
    
    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    
            val btn_click_me : Button = findViewById(R.id.btn_click_me)
            val tv_people_num : TextView = findViewById(R.id.tv_people_num)
            var people_num = 0
    
            btn_click_me.setOnClickListener()
            {
                people_num++
                tv_people_num.text = people_num.toString()
                Toast.makeText(this, "total : ${people_num}", Toast.LENGTH_SHORT).show()
    
            }
    
        }
    
    }
    ```
    

- [ ]  안드로이드 스튜디오 시작하기 15 & 16 - 안드로이드 휴대폰에 앱 설치하기