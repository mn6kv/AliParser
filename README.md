# AliParser
## Как сделал:
1. Изучив код страницы и почитав интернет, нашел, что данные подгружаются скриптом Request URL: https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery183048246769344436435_1615212363465&widget_id=5547572&platform=pc&limit=12&offset=0&phase=1&productIds2Top=&postback=&_=1615212370475
2. Перейдя по ссылке, увидел данные в формате Json, создал класс, в который можно записать эти данные(решил использовать класс, потому что, хоть заданием не предусмотрено, в будущем это дает возможност сохранять в базу данных)
3. Затем записал данные из класса в файлик src\main\resources\result\products.csv

### Для работы программы следует запустить ru.itis.mn6kv.run.Main