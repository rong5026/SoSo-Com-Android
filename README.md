## 나홀로편의점
### 시각장애인분들의 편의성 증진을 위한 품목 구별 앱서비스입니다.

<p>
  <img src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white"/>
  <img src="https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Colab-F9AB00?style=flat-square&logo=Google Colab&logoColor=white"/>
  <img src="https://img.shields.io/badge/Pytorch-EE4C2C?style=flat-square&logo=pytorch&logoColor=white"/>
  <img src="https://img.shields.io/badge/Yolov5-00FFFF?style=flat-square&logo=yolo&logoColor=white"/>
</p>

---------------------------------------

### 📹 Demonstration video
* [https://youtu.be/CI2B0MH9_zg](https://youtu.be/CI2B0MH9_zg)

---------------------------------------

### 🌱 Background
* [뉴스기사](https://www.fnnews.com/news/202203211831219738) 및 유튜버 ‘원샷한솔’님의 컨텐츠들을 보면서 점자 표시 미흡으로 인한 시각장애인분들의 불편함을 인지
* https://www.youtube.com/watch?v=fq5xQaWaMO0 (과자)
* https://www.youtube.com/watch?v=PDDyhWiIZsE (음료)
* https://www.youtube.com/shorts/z5ywaMWtQys (라면)
* 점자표시가 되어있는 품목들도 있지만, 미흡하거나 없는 품목들이 다수
* 따라서 핸드폰을 사용하여 어떤 품목인지 알려주는 서비스를 생각하게 되었음.



### 🌱 Service
* 음성을 활용하여 어플 실행 및, 안내
* 카메라를 활용하여 실시간으로 화면에 노출되어있는 품목의 정보를 음성으로 출력
* 음성으로 입력한 품목이 탐지될경우 알려주는 기능

### 🌱 System Architecture
<img src="https://user-images.githubusercontent.com/102522202/190141921-53f38bcd-d9f3-4da6-9327-511af60ae3ba.png" width="1000" height="500"/>

---------------------------------------

### 🌱 DataSet
* AI Hub '상품 이미지' 데이터 사용
* roboflow를 활용하여 yolov5-pytorch용 데이터셋 구축
* python을 활용하여 학습 전 데이터 전처리작업 수행
* [yolov5_train_ptl.ipynb](https://github.com/En-soso-com/Android/blob/main/yolov5_train_ptl.ipynb)을 활용하여 학습진행
* ptl모델로 변환 후 android에서 사용


### 🥤 Beverage DataSet

|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|
|----|----|----|----|----|----|----|----|
|<sub><sup>1</sup></sub>|<sub><sup>한국쥬맥스)모구모구리치맛</sup></sub>|<sub><sup>14</sup></sub>|<sub><sup>롯데게토레이240ML</sup></sub>|<sub><sup>27</sup></sub>|<sub><sup>롯데마운틴듀250ML</sup></sub>|<sub><sup>40</sup></sub>|<sub><sup>코카콜라)킨사이다185ML</sup></sub>|
|<sub><sup>2</sup></sub>|<sub><sup>한국쥬맥스)모구모구복숭아향</sup></sub>|<sub><sup>15</sup></sub>|<sub><sup>코카콜라190ML</sup></sub>|<sub><sup>28</sup></sub>|<sub><sup>롯데마운틴듀400ML</sup></sub>|<sub><sup>41</sup></sub>|<sub><sup>코카콜라)코카콜라350ML</sup></sub>|
|<sub><sup>3</sup></sub>|<sub><sup>롯데트로피카나스파클링파인애플355ML</sup></sub>|<sub><sup>16</sup></sub>|<sub><sup>일화맥콜250ML</sup></sub>|<sub><sup>29</sup></sub>|<sub><sup>코카콜라제로500ML</sup></sub>|<sub><sup>42</sup></sub>|<sub><sup>코카콜라오리지널300ML</sup></sub>|
|<sub><sup>4</sup></sub>|<sub><sup>동아포카리스웨트(캔)340ML</sup></sub>|<sub><sup>17</sup></sub>|<sub><sup>롯데핫식스더킹파워355ML</sup></sub>|<sub><sup>30</sup></sub>|<sub><sup>롯데펩시콜라600ML</sup></sub>|<sub><sup>43</sup></sub>|<sub><sup>동아포카리스웨트500ML</sup></sub>|
|<sub><sup>5</sup></sub>|<sub><sup>해태)코코팜복숭아300ML</sup></sub>|<sub><sup>18</sup></sub>|<sub><sup>코코팜망고코넛340ML</sup></sub>|<sub><sup>31</sup></sub>|<sub><sup>코카토레타500ML</sup></sub>|<sub><sup>44</sup></sub>|<sub><sup>해태갈배사이다238ML</sup></sub>|
|<sub><sup>6</sup></sub>|<sub><sup>롯데)미린다오렌지355ML</sup></sub>|<sub><sup>19</sup></sub>|<sub><sup>농심)파워오투애플키워향</sup></sub>|<sub><sup>32</sup></sub>|<sub><sup>코카콜라355ML</sup></sub>|<sub><sup>45</sup></sub>|<sub><sup>롯데핫식스자몽250ML</sup></sub>|
|<sub><sup>7</sup></sub>|<sub><sup>해태)복숭아봉봉340ML</sup></sub>|<sub><sup>20</sup></sub>|<sub><sup>농심)파워오투오렌지레몬향</sup></sub>|<sub><sup>33</sup></sub>|<sub><sup>롯데)2%부족할때아쿠아500ML</sup></sub>|<sub><sup>46</sup></sub>|<sub><sup>해태갈배사이다355ML</sup></sub>|
|<sub><sup>8</sup></sub>|<sub><sup>롯데)펩시콜라210ML</sup></sub>|<sub><sup>21</sup></sub>|<sub><sup>코카)제로코카콜라215ML</sup></sub>|<sub><sup>34</sup></sub>|<sub><sup>농심)파워오투아이스베리향</sup></sub>|<sub><sup>47</sup></sub>|<sub><sup>코카콜라제로250ML</sup></sub>|
|<sub><sup>9</sup></sub>|<sub><sup>코카환타오렌지250ML</sup></sub>|<sub><sup>22</sup></sub>|<sub><sup>코카)스프라이트215ML</sup></sub>|<sub><sup>35</sup></sub>|<sub><sup>코카스프라이트500ML</sup></sub>|<sub><sup>48</sup></sub>|<sub><sup>롯데마운틴듀355ML</sup></sub>|
|<sub><sup>10</sup></sub>|<sub><sup>해태갈아만든배340ML</sup></sub>|<sub><sup>23</sup></sub>|<sub><sup>코카환타오렌지185ML</sup></sub>|<sub><sup>36</sup></sub>|<sub><sup>동아오츠카데미소다자몽250ML</sup></sub>|<sub><sup>49</sup></sub>|<sub><sup>롯데레쓰비175ML</sup></sub>|
|<sub><sup>11</sup></sub>|<sub><sup>농심웰치스포도355ml</sup></sub>|<sub><sup>24</sup></sub>|<sub><sup>해태갈배사이다210ML</sup></sub>|<sub><sup>37</sup></sub>|<sub><sup>롯데사랑초톡톡스파클링330ML</sup></sub>|<sub><sup>50</sup></sub>|<sub><sup>롯데밀키스500ML</sup></sub>|
|<sub><sup>12</sup></sub>|<sub><sup>코카파워에이드MB520ML</sup></sub>|<sub><sup>25</sup></sub>|<sub><sup>코카환타오렌지215ML</sup></sub>|<sub><sup>38</sup></sub>|<sub><sup>조지아고티카빈티지블랙390ML</sup></sub>|<sub><sup>51</sup></sub>|<sub><sup>코카환타포도250ML</sup></sub>|
|<sub><sup>13</sup></sub>|<sub><sup>코카파워에이드MB600ML</sup></sub>|<sub><sup>26</sup></sub>|<sub><sup>해태갈배사이다500ML</sup></sub>|<sub><sup>39</sup></sub>|<sub><sup>롯데칸타타아메리카노200ML</sup></sub>|<sub><sup>52</sup></sub>|<sub><sup>일화)맥콜500ML</sup></sub>|



### 🍭 Snack DataSet

|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|
|----|----|----|----|----|----|----|----|
|<sub><sup>1</sup></sub>|<sub><sup>농심켈로그)프링글스마늘감자구이맛110G</sup></sub>|<sub><sup>14</sup></sub>|<sub><sup>오리온촉촉한초코칩240G</sup></sub>|<sub><sup>27</sup></sub>|<sub><sup>크라운초코하임142G</sup></sub>|<sub><sup>40</sup></sub>|<sub><sup>농심오징어집83G</sup></sub>|
|<sub><sup>2</sup></sub>|<sub><sup>농심켈로그)프링글스버팔로윙맛110G</sup></sub>|<sub><sup>15</sup></sub>|<sub><sup>롯데)롯샌파인애플315G</sup></sub>|<sub><sup>28</sup></sub>|<sub><sup>롯데야채크래커249G<sub><sup></sup></sub>|<sub><sup>41</sup></sub>|<sub><sup>롯데석기시대90G</sup></sub>|
|<sub><sup>3</sup></sub>|<sub><sup>오리온)포카칩오리지널66G</sup></sub>|<sub><sup>16</sup></sub>|<sub><sup>농심수미칩오리지널85G</sup></sub>|<sub><sup>29</sup></sub>|<sub><sup>롯데빠다코코낫300G</sup></sub><sub><sup>|<sub><sup>42</sup></sub>|<sub><sup>해태오예스360G</sup></sub>|
|<sub><sup>4</sup></sub>|<sub><sup>스모키베이컨칩매콤불맛70G</sup></sub>|<sub><sup>17</sup></sub>|<sub><sup>프링글스오리지날110G</sup></sub>|<sub><sup>30</sup></sub>|<sub><sup>꼬깔콘고소한맛72G</sup></sub>|<sub><sup>43</sup></sub>|<sub><sup>롯데ABC밀크65G</sup></sub>|
|<sub><sup>5</sup></sub>|<sub><sup>농심)프링글스클래식110G</sup></sub>|<sub><sup>18</sup></sub>|<sub><sup>해태롤리폴리초코196G</sup></sub>|<sub><sup>31</sup></sub>|<sub><sup>농심매운새우깡90G</sup></sub>|<sub><sup>44</sup></sub>|<sub><sup>농심)프링글스버터캬라멜110G</sup></sub>|
|<sub><sup>6</sup></sub>|<sub><sup>농심칩포테토오리지날125G</sup></sub>|<sub><sup>19</sup></sub>|<sub><sup>크라운쫀득초코칩240G</sup></sub>|<sub><sup>32</sup></sub>|<sub><sup>매일킨더초코렛T4</sup></sub>|<sub><sup>45</sup></sub>|<sub><sup>롯데)롯샌화이트크림깜뜨315G</sup></sub>|
|<sub><sup>7</sup></sub>|<sub><sup>오리온후레쉬베리딸기336G</sup></sub>|<sub><sup>20</sup></sub>|<sub><sup>오리온초코칩쿠키256G</sup></sub>|<sub><sup>33</sup></sub>|<sub><sup>롯데초코파이420G</sup></sub>|<sub><sup>46</sup></sub>|<sub><sup>켈로그)프링글스사워크림</sup></sub>|
|<sub><sup>8</sup></sub>|<sub><sup>해태오예스쿠키앤크림360G</sup></sub>|<sub><sup>21</sup></sub>|<sub><sup>크라운빅파이딸기324G</sup></sub>|<sub><sup>34</sup></sub>|<sub><sup>삼립누네띠네500G</sup></sub>|<sub><sup>47</sup></sub>|<sub><sup>오리온)예감치즈그라탕2P64G</sup></sub>|
|<sub><sup>9</sup></sub>|<sub><sup>농심)프링글스클래식53G</sup></sub>|<sub><sup>22</sup></sub>|<sub><sup>해태)허니버터칩38G</sup></sub>|<sub><sup>35</sup></sub>|<sub><sup>크라운쿠크다스화이트토르테64G</sup></sub>|<sub><sup>48</sup></sub>|<sub><sup>삼양)사또밥갈릭버터맛52G</sup></sub>|
|<sub><sup>10</sup></sub>|<sub><sup>롯데마가렛트오리지널88G</sup></sub>|<sub><sup>23</sup></sub>|<sub><sup>농심수미칩어니언85G</sup></sub>|<sub><sup>36</sup></sub>|<sub><sup>크라운)콘초66G</sup></sub>|<sub><sup>49</sup></sub>|<sub><sup>해태)맛동산90G</sup></sub>|
|<sub><sup>11</sup></sub>|<sub><sup>오리온)초코파이(12입)468G</sup></sub>|<sub><sup>24</sup></sub>|<sub><sup>롯데몽쉘오리지날생크림케이크384G</sup></sub>|<sub><sup>37</sup></sub>|<sub><sup>농심알새우칩68G</sup></sub>|<sub><sup></sup></sub>|<sub><sup></sup></sub>|
|<sub><sup>12</sup></sub>|<sub><sup>크라운국희땅콩샌드155G</sup></sub>|<sub><sup>25</sup></sub>|<sub><sup>롯데)오징어땅콩90G</sup></sub>|<sub><sup>38</sup></sub>|<sub><sup>농심바나나킥75G</sup></sub>|<sub><sup></sup></sub>|<sub><sup></sup></sub>|
|<sub><sup>13</sup></sub>|<sub><sup>동서오레오초콜릿샌드위치쿠키100G</sup></sub>|<sub><sup>26</sup></sub>|<sub><sup>프링글스치즈맛110G</sup></sub>|<sub><sup>39</sup></sub>|<sub><sup>오리온고소미80G</sup></sub>|<sub><sup></sup></sub>|<sub><sup></sup></sub>|

### 🍜 Noodle DataSet

|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|<sub><sup>순번</sup></sub>|<sub><sup>품목</sup></sub>|
|----|----|----|----|----|----|----|----|
|<sub><sup>1</sup></sub>|<sub><sup>오뚜기참깨라면(컵)</sup></sub>|<sub><sup>21</sup></sub>|<sub><sup>팔도김치도시락86G</sup></sub>|<sub><sup>41</sup></sub>|<sub><sup>오뚜기스파게티컵120G</sup></sub>|<sub><sup>61</sup></sub>|<sub><sup>오뚜기)쇠고기미역국라면100G</sup></sub>|
|<sub><sup>2</sup></sub>|<sub><sup>삼양크림까르보불닭볶음면큰컵120G</sup></sub>|<sub><sup>22</sup></sub>|<sub><sup>농심신라면컵65G</sup></sub>|<sub><sup>42</sup></sub>|<sub><sup>농심)사리곰탕컵61G|<sub><sup>62</sup></sub>|<sub><sup>농심오징어짬뽕큰사발115G</sup></sub>|
|<sub><sup>3</sup></sub>|<sub><sup>삼양미트스파게티불닭볶음면110G</sup></sub>|<sub><sup>23</sup></sub>|<sub><sup>오뚜기컵누들얼큰쌀국수37.8G</sup></sub>|<sub><sup>43</sup></sub>|<sub><sup>농심순한너구리컵63G</sup></sub>|<sub><sup>63</sup></sub>|<sub><sup>삼양큰컵불닭볶음면105G</sup></sub>|
|<sub><sup>4</sup></sub>|<sub><sup>오뚜기)컵누들김치쌀국수34.8G</sup></sub>|<sub><sup>24</sup></sub>|<sub><sup>오뚜기진라면순한맛컵110G</sup></sub>|<sub><sup>44</sup></sub>|<sub><sup>오뚜기새우탕면110G</sup></sub>|<sub><sup>64</sup></sub>|<sub><sup>오뚜기참깨라면용기110G</sup></sub>|
|<sub><sup>5</sup></sub>|<sub><sup>오뚜기컵누들잔치쌀국수37.8G</sup></sub>|<sub><sup>25</sup></sub>|<sub><sup>오뚜기열라면컵105G</sup></sub>|<sub><sup>45</sup></sub>|<sub><sup>오뚜기진진짜라120G</sup></sub>|<sub><sup>65</sup></sub>|<sub><sup>오뚜기진라면매운맛65G(작은용기)</sup></sub>|
|<sub><sup>6</sup></sub>|<sub><sup>팔도더왕뚜껑컵순한맛101G</sup></sub>|<sub><sup>26</sup></sub>|<sub><sup>오뚜기육개장컵110G</sup></sub>|<sub><sup>46</sup></sub>|<sub><sup>농심생생우동면276G</sup></sub>|<sub><sup>66</sup></sub>|<sub><sup>오뚜기육개장용기면86G</sup></sub>|
|<sub><sup>7</sup></sub>|<sub><sup>오뚜기진라면매운맛컵110G</sup></sub>|<sub><sup>27</sup></sub>|<sub><sup>팔도삼선짜장</sup></sub>|<sub><sup>47</sup></sub>|<sub><sup>농심)감자면92G</sup></sub>|<sub><sup>67</sup></sub>|<sub><sup>농심육개장큰사발110G</sup></sub>|
|<sub><sup>8</sup></sub>|<sub><sup>삼양짜장불닭볶음면105G</sup></sub>|<sub><sup>28</sup></sub>|<sub><sup>농심신라면건면</sup></sub>|<sub><sup>48</sup></sub>|<sub><sup>팔도왕뚜껑110G</sup></sub>|<sub><sup>68</sup></sub>|<sub><sup>농심무파마큰사발112G</sup></sub>|
|<sub><sup>9</sup></sub>|<sub><sup>농심사천짜파게티컵115G</sup></sub>|<sub><sup>29</sup></sub>|<sub><sup>팔도일품해물라면</sup></sub>|<sub><sup>49</sup></sub>|<sub><sup>삼양라면110g</sup></sub>|<sub><sup>69</sup></sub>|<sub><sup>농심우육탕큰사발115G</sup></sub>|
|<sub><sup>10</sup></sub>|<sub><sup>농심짜파게티큰사발123G</sup></sub>|<sub><sup>30</sup></sub>|<sub><sup>오뚜기부대찌개라면</sup></sub>|<sub><sup>50</sup></sub>|<sub><sup>팔도비빔면컵</sup></sub>|<sub><sup>70</sup></sub>|<sub><sup>오뚜기진라면컵순65G</sup></sub>|
|<sub><sup>11</sup></sub>|<sub><sup>농심새우탕컵(소)67G</sup></sub>|<sub><sup>31</sup></sub>|<sub><sup>농심참치마요큰사발면</sup></sub>|<sub><sup>51</sup></sub>|<sub><sup>종가집얼큰쌀국수</sup></sub>|<sub><sup>71</sup></sub>|<sub><sup>농심짜파게티범벅70G</sup></sub>|
|<sub><sup>12</sup></sub>|<sub><sup>오뚜기오동통면컵100G</sup></sub>|<sub><sup>32</sup></sub>|<sub><sup>삼양)까르보불닭볶음면큰컵105G</sup></sub>|<sub><sup>52</sup></sub>|<sub><sup>농심짜왕큰사발면</sup></sub>|<sub><sup>72</sup></sub>|<sub><sup>농심튀김우동컵62G</sup></sub>|
|<sub><sup>13</sup></sub>|<sub><sup>오뚜기짜장볶이컵120G</sup></sub>|<sub><sup>33</sup></sub>|<sub><sup>삼양)치즈불닭볶음면큰컵105G</sup></sub>|<sub><sup>53</sup></sub>|<sub><sup>농심너구리큰사발면111G</sup></sub>|<sub><sup>73</sup></sub>|<sub><sup>팔도도시락용기86G</sup></sub>|
|<sub><sup>14</sup></sub>|<sub><sup>오뚜기컵누들매콤37.8G</sup></sub>|<sub><sup>34</sup></sub>|<sub><sup>삼양)쫄볶이불닭볶음면120G</sup></sub>|<sub><sup>54</sup></sub>|<sub><sup>농심쌀국수</sup></sub>|<sub><sup>74</sup></sub>|<sub><sup>얼큰한쌀국수92G</sup></sub>|
|<sub><sup>15</sup></sub>|<sub><sup>오뚜기컵누들우동38.1G</sup></sub>|<sub><sup>35</sup></sub>|<sub><sup>삼양)삼양라면매운맛110G</sup></sub>|<sub><sup>55</sup></sub>|<sub><sup>오뚜기스낵면컵</sup></sub>|<sub><sup>75</sup></sub>|<sub><sup>오뚜기)굴진짬뽕</sup></sub>|
|<sub><sup>16</sup></sub>|<sub><sup>농심오징어짬뽕컵67G</sup></sub>|<sub><sup>36</sup></sub>|<sub><sup>농심)신라면큰사발면114G</sup></sub>|<sub><sup>56</sup></sub>|<sub><sup>농심김치큰사발면</sup></sub>|<sub><sup>76</sup></sub>|<sub><sup>삼양)나가사끼짬뽕</sup></sub>|
|<sub><sup>17</sup></sub>|<sub><sup>오뚜기김치면컵105G</sup></sub>|<sub><sup>37</sup></sub>|<sub><sup>농심사리곰탕큰사발111G</sup></sub>|<sub><sup>57</sup></sub>|<sub><sup>종가집)멸치쌀국수</sup></sub>|<sub><sup>77</sup></sub>|<sub><sup>농심새우탕큰사발115G</sup></sub>|
|<sub><sup>18</sup></sub>|<sub><sup>팔도짬뽕왕뚜껑110G</sup></sub>|<sub><sup>38</sup></sub>|<sub><sup>삼양)불닭볶음탕면120G</sup></sub>|<sub><sup>58</sup></sub>|<sub><sup>농심볶음너구리큰사발면</sup></sub>|<sub><sup>78</sup></sub>|<sub><sup>오뚜기튀김우동컵110G</sup></sub>|
|<sub><sup>19</sup></sub>|<sub><sup>오뚜기진짜장컵115G</sup></sub>|<sub><sup>39</sup></sub>|<sub><sup>농심)신라면블랙101G</sup></sub>|<sub><sup>59</sup></sub>|<sub><sup>농심보글보글부대찌개큰사발면</sup></sub>|<sub><sup>79</sup></sub>|<sub><sup>농심김치사발면86G</sup></sub>|
|<sub><sup>20</sup></sub>|<sub><sup>오뚜기라면볶이120G</sup></sub>|<sub><sup>40</sup></sub>|<sub><sup>오뚜기크림진짬뽕105G</sup></sub>|<sub><sup>60</sup></sub>|<sub><sup>농심)앵그리짜파구리큰사발108G</sup></sub>|<sub><sup>80</sup></sub>|<sub><sup>멸치맛쌀국수92G</sup></sub>|

---------------------------------------

### 📌 Result
<img src="https://user-images.githubusercontent.com/101173462/189529335-e0d640fe-a82a-4832-a9d4-49555d667882.png" width="800" height="400"/>
<p>
  <img src="https://user-images.githubusercontent.com/101173462/189529553-9c7dd6ec-09d9-435a-a5bf-f89feef64126.jpg" width="300" height="300"/>
  <img src="https://user-images.githubusercontent.com/101173462/190083588-e2a1ef94-05d2-4450-bf3f-53d6e83e58a6.jpg" width="300" height="300"/>
  <img src="https://user-images.githubusercontent.com/102522202/190088011-b0e189a7-e74a-4eb7-a7f7-36c4907da59e.jpg" width="300" height="300"/>
</p>

---------------------------------------

### 📱 In App
<p>
  <img src="https://user-images.githubusercontent.com/101173462/190165419-fb0c10ac-ab56-44be-adc6-a435112cb758.jpeg" width="300" height="600"/>
  <img src="https://user-images.githubusercontent.com/101173462/190165447-21b79aa1-1955-4425-a1eb-df2143a217ca.jpeg" width="300" height="600"/>
  <img src="https://user-images.githubusercontent.com/101173462/190165471-231b63b9-c63d-4c07-91aa-97365e7dd886.jpeg" width="300" height="600"/>
</p>


---------------------------------------

### 🌱 Reference
* https://github.com/ultralytics/yolov5
* https://github.com/pytorch/android-demo-app/tree/master/ObjectDetection

