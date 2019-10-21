# LiApi
### 说明：  
一个后台应用，只写api接口，所有的请求和回复均使用json数据格式。  
由于各大数据平台不再提供免费的api接口，实行实名制或次数有限，故此自己编写api接口。
不仅可以练习编写Java后台程序，还可以在学习前端知识框架时给自己提供api接口。 

### 开发环境、工具：  
* IntelliJ IDEA 2019.2.1 x64  Community版  
* SpringBoot + Mybatis,数据存储在UniServer，一个小的无需安装的数据库软件  
* 框架：Mybatis、pagehelper
* Postman调试  
  
UniServer数据库更新：20191021  
  
### 接口示例  
url:
```
http://127.0.0.1:8080/jokeTheme/list
```
requestBody:
```
{
	"pageNum":1,
	"pageSize":5
}
```
response:
```
{
    "code": 200,
    "msg": "查询成功",
    "data": [
        {
            "id": 1,
            "themeId": "1001",
            "title": "冷笑话",
            "brief": "冷冷的生活小讽刺",
            "picUrl": "http://dkj.jpg",
            "count": 2458
        },
        {
            "id": 2,
            "themeId": "1002",
            "title": "幽默",
            "brief": "幽默有趣的逗B笑段",
            "picUrl": "http://dkj.jpg",
            "count": 2458
        },
        {
            "id": 4,
            "themeId": "1004",
            "title": "内涵",
            "brief": "搞笑的吹牛、内涵冷段子",
            "picUrl": "http://d9894u.png",
            "count": 1
        }
    ]
}
```
  
  
### 各个接口（CRUD）：  
[1、jokeTheme：笑话的分类](https://github.com/shuguoli68/LiApi/blob/master/docs/jokeTheme.md)  
[2、joke：笑话](https://github.com/shuguoli68/LiApi/blob/master/docs/joke.md)  
[3、province：省](https://github.com/shuguoli68/LiApi/blob/master/docs/province.md)  
[4、city：市](https://github.com/shuguoli68/LiApi/blob/master/docs/city.md)  
[5、area：区](https://github.com/shuguoli68/LiApi/blob/master/docs/area.md)  

