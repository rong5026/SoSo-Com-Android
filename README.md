## 나홀로편의점
### 시각장애인분들의 편의성 증진을 위한 품목 구별 앱서비스입니다.

<p>
  <img src="https://img.shields.io/badge/Python-0000FF?style=flat-square&logo=python&logoColor=white"/>
  <img src="https://img.shields.io/badge/Android-008000?style=flat-square&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Pytorch-FF8C00?style=flat-square&logo=pytorch&logoColor=white"/>
  <img src="https://img.shields.io/badge/Yolov5-4682B4?style=flat-square&logo=yolo&logoColor=white"/>
</p>




### 🌱 배경
* [뉴스기사](https://www.fnnews.com/news/202203211831219738) 및 유튜버 ‘원샷한솔’님의 컨텐츠들을 보면서 점자 표시 미흡으로 인한 시각장애인분들의 불편함을 인지
* https://www.youtube.com/watch?v=fq5xQaWaMO0 (과자)
* https://www.youtube.com/watch?v=PDDyhWiIZsE (음료)
* https://www.youtube.com/shorts/z5ywaMWtQys (라면)
* 점자표시가 되어있는 품목들도 있지만, 약하거나 없는 품목들이 다수
* 따라서 핸드폰을 사용하여 어떤 품목인지 알려주는 서비스를 생각하게 되었음.



### 🌱 기능
* 음성을 활용하여 어플 실행 및, 안내
* 카메라를 활용하여 실시간으로 화면에 노출되어있는 품목의 정보를 음성으로 출력
* 음성으로 입력한 품목이 탐지될경우 알려주는 기능 
* 화면을 탭 할경우 탐지한 품목의 이벤트 유무, 가격정보 등 추가정보 출력



### 🌱 데이터셋
* AI Hub '상품 이미지' 데이터 사용
* roboflow를 활용하여 yolov5-pytorch용 데이터셋 구축
* ptl모델로 변환 후 android에서 사용




### 라면품목 데이터셋

|<sub>순번</sub>|<sub>품목</sub>|<sub>순번</sub>|<sub>품목</sub>|<sub>순번</sub>|<sub>품목</sub>|<sub>순번</sub>|<sub>품목</sub>|
|----|----|----|----|----|----|----|----|
|<sub>1</sub>|<sub><sup>오뚜기참깨라면(컵)</sup></sub>|<sub>21</sub>|<sub><sup>팔도김치도시락86G</sup></sub>|<sub>41</sub>|<sub><sup>오뚜기스파게티컵120G</sup></sub>|<sub>61</sub>|<sub><sup>오뚜기)쇠고기미역국라면100G</sup></sub>|
|<sub>2</sub>|<sub><sup>삼양크림까르보불닭볶음면큰컵120G</sup></sub>|<sub>22</sub>|<sub><sup>농심신라면컵65G</sup></sub>|<sub>42</sub>|<sub><sup>농심)사리곰탕컵61G|<sub>62</sub>|<sub><sup>농심오징어짬뽕큰사발115G</sup></sub>|
|<sub>3</sub>|<sub><sup>삼양미트스파게티불닭볶음면110G</sup></sub>|<sub>23</sub>|<sub><sup>오뚜기컵누들얼큰쌀국수37.8G</sup></sub>|<sub>43</sub>|<sub><sup>농심순한너구리컵63G</sub>|<sub>63|<sub><sup>삼양큰컵불닭볶음면105G</sup></sub>|
|<sub>4</sub>|<sub><sup>오뚜기)컵누들김치쌀국수34.8G</sup></sub>|<sub>24</sub>|<sub><sup>오뚜기진라면순한맛컵110G</sup></sub>|<sub>44</sub>|<sub><sup>오뚜기새우탕면110G</sup></sub>|<sub>64</sub>|<sub><sup>오뚜기참깨라면용기110G</sup></sub>|
|<sub>5</sub>|<sub><sup>오뚜기컵누들잔치쌀국수37.8G</sup></sub>|<sub>25</sub>|<sub><sup>오뚜기열라면컵105G</sup></sub>|<sub>45</sub>|<sub><sup>오뚜기진진짜라120G</sup></sub>|<sub>65</sub>|<sub><sup>오뚜기진라면매운맛65G(작은용기)</sup></sub>|
|<sub>6</sub>|<sub><sup>팔도더왕뚜껑컵순한맛101G</sup></sub>|<sub>26</sub>|<sub><sup>오뚜기육개장컵110G</sup></sub>|<sub>46</sub>|<sub><sup>농심생생우동면276G</sup></sub>|<sub>66</sub>|<sub><sup>오뚜기육개장용기면86G</sup></sub>|
|<sub>7</sub>|<sub><sup>오뚜기진라면매운맛컵110G</sup></sub>|<sub>27</sub>|<sub><sup>팔도삼선짜장</sup></sub>|<sub>47</sub>|<sub><sup>농심)감자면92G</sup></sub>|<sub>67</sub>|<sub><sup>농심육개장큰사발110G</sup></sub>|
|<sub>8</sub>|<sub><sup>삼양짜장불닭볶음면105G</sup></sub>|<sub>28</sub>|<sub><sup>농심신라면건면</sup></sub>|<sub>48</sub>|<sub><sup>팔도왕뚜껑110G</sup></sub>|<sub>68</sub>|<sub><sup>농심무파마큰사발112G</sup></sub>|
|<sub>9</sub>|<sub><sup>농심사천짜파게티컵115G</sup></sub>|<sub>29</sub>|<sub><sup>팔도일품해물라면</sup></sub>|<sub>49</sub>|<sub><sup>삼양라면110g</sup></sub>|<sub>69</sub>|<sub><sup>농심우육탕큰사발115G</sup></sub>|
|<sub>10</sub>|<sub><sup>농심짜파게티큰사발123G</sup></sub>|<sub>30</sub>|<sub><sup>오뚜기부대찌개라면</sup></sub>|<sub>50</sub>|<sub><sup>팔도비빔면컵</sup></sub>|<sub>70</sub>|<sub><sup>오뚜기진라면컵순65G</sup></sub>|
|<sub>11</sub>|<sub><sup>농심새우탕컵(소)67G</sup></sub>|<sub>31</sub>|<sub><sup>농심참치마요큰사발면</sup></sub>|<sub>51</sub>|<sub><sup>종가집얼큰쌀국수</sup></sub>|<sub>71</sub>|<sub><sup>농심짜파게티범벅70G</sup></sub>|
|<sub>12</sub>|<sub><sup>오뚜기오동통면컵100G</sup></sub>|<sub>32</sub>|<sub><sup>삼양)까르보불닭볶음면큰컵105G</sup></sub>|<sub>52</sub>|<sub><sup>농심짜왕큰사발면</sup></sub>|<sub>72</sub>|<sub><sup>농심튀김우동컵62G</sup></sub>|
|<sub>13</sub>|<sub><sup>오뚜기짜장볶이컵120G</sup></sub>|<sub>33</sub>|<sub><sup>삼양)치즈불닭볶음면큰컵105G</sup></sub>|<sub>53</sub>|<sub><sup>농심너구리큰사발면111G</sup></sub>|<sub>73</sub>|<sub><sup>팔도도시락용기86G</sup></sub>|
|<sub>14</sub>|<sub><sup>오뚜기컵누들매콤37.8G</sup></sub>|<sub>34</sub>|<sub><sup>삼양)쫄볶이불닭볶음면120G</sup></sub>|<sub>54</sub>|<sub><sup>농심쌀국수</sup></sub>|<sub>74</sub>|<sub><sup>얼큰한쌀국수92G</sup></sub>|
|<sub>15</sub>|<sub><sup>오뚜기컵누들우동38.1G</sup></sub>|<sub>35</sub>|<sub><sup>삼양)삼양라면매운맛110G</sup></sub>|<sub>55</sub>|<sub><sup>오뚜기스낵면컵</sup></sub>|<sub>75</sub>|<sub><sup>오뚜기)굴진짬뽕</sup></sub>|
|<sub>16</sub>|<sub><sup>농심오징어짬뽕컵67G</sup></sub>|<sub>36</sub>|<sub><sup>농심)신라면큰사발면114G</sup></sub>|<sub>56</sub>|<sub><sup>농심김치큰사발면</sup></sub>|<sub>76</sub>|<sub><sup>삼양)나가사끼짬뽕</sup></sub>|
|<sub>17</sub>|<sub><sup>오뚜기김치면컵105G</sup></sub>|<sub>37</sub>|<sub><sup>농심사리곰탕큰사발111G</sup></sub>|<sub>57</sub>|<sub><sup>종가집)멸치쌀국수</sup></sub>|<sub>77</sub>|<sub><sup>농심새우탕큰사발115G</sup></sub>|
|<sub>18</sub>|<sub><sup>팔도짬뽕왕뚜껑110G</sup></sub>|<sub>38</sub>|<sub><sup>삼양)불닭볶음탕면120G</sup></sub>|<sub>58</sub>|<sub><sup>농심볶음너구리큰사발면</sup></sub>|<sub>78</sub>|<sub><sup>오뚜기튀김우동컵110G</sup></sub>|
|<sub>19</sub>|<sub><sup>오뚜기진짜장컵115G</sup></sub>|<sub>39</sub>|<sub><sup>농심)신라면블랙101G</sup></sub>|<sub>59</sub>|<sub><sup>농심보글보글부대찌개큰사발면</sup></sub>|<sub>79</sub>|<sub><sup>농심김치사발면86G</sup></sub>|
|<sub>20</sub>|<sub><sup>오뚜기라면볶이120G</sup></sub>|<sub>40</sub>|<sub><sup>오뚜기크림진짬뽕105G</sup></sub>|<sub>60</sub>|<sub><sup>농심)앵그리짜파구리큰사발108G</sup></sub>|<sub>80</sub>|<sub><sup>멸치맛쌀국수92G</sup></sub>|

<img src="https://user-images.githubusercontent.com/101173462/189529335-e0d640fe-a82a-4832-a9d4-49555d667882.png" width="800" height="400"/>
<img src="https://user-images.githubusercontent.com/101173462/189529553-9c7dd6ec-09d9-435a-a5bf-f89feef64126.jpg" width="800" height="400"/>



### 🌱 참조
* https://github.com/ultralytics/yolov5
* https://github.com/pytorch/android-demo-app/tree/master/ObjectDetection

