## 나홀로편의점
### 시각장애인분들의 편의성 증진을 위한 품목 구별 앱서비스입니다.

<p>
  <img src="https://img.shields.io/badge/Python-0000FF?style=flat-square&logo=python&logoColor=white"/>
  <img src="https://img.shields.io/badge/Android-008000?style=flat-square&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Pytorch-FF8C00?style=flat-square&logo=pytorch&logoColor=white"/>
  <img src="https://img.shields.io/badge/Yolov5-4682B4?style=flat-square&logo=yolo&logoColor=white"/>
</p>





### 배경
* [뉴스기사](https://www.fnnews.com/news/202203211831219738) 및 유튜버 ‘원샷한솔’님의 컨텐츠들을 보면서 점자 표시 미흡으로 인한 시각장애인분들의 불편함을 인지
* https://www.youtube.com/watch?v=fq5xQaWaMO0 (과자)
* https://www.youtube.com/watch?v=PDDyhWiIZsE (음료)
* https://www.youtube.com/shorts/z5ywaMWtQys (라면)
* 점자표시가 되어있는 품목들도 있지만, 약하거나 없는 품목들이 다수
* 따라서 핸드폰을 사용하여 어떤 품목인지 알려주는 서비스를 생각하게 되었음.



### 기능
* 음성을 활용하여 어플 실행 및, 안내
* 카메라를 활용하여 실시간으로 화면에 노출되어있는 품목의 정보를 음성으로 출력
* 음성으로 입력한 품목이 탐지될경우 알려주는 기능 
* 화면을 탭 할경우 탐지한 품목의 이벤트 유무, 가격정보 등 추가정보 출력



### 데이터셋
* AI Hub '상품 이미지' 데이터 사용
* roboflow를 활용하여 yolov5-pytorch용 데이터셋 구축
* ptl모델로 변환 후 android에서 사용

### 참조
* https://github.com/ultralytics/yolov5
* https://github.com/pytorch/android-demo-app/tree/master/ObjectDetection

