# Lecture9 課題
## 概要
従業員の情報を管理するためのRESTfulAPIを提供するものです.
全ての従業員を取得したり、特定のIDや部署の従業員を取得したりすることができます.

## 実装内容
- **Employeeエンティティ**: 従業員の情報を表すエンティティクラス.
- **EmployeeMapperインターフェース**: データベースの操作を行うマッパー.具体的なSQLクエリが定義されています.
- **EmployeeServiceインターフェースとその実装EmployeeServiceImpl**: 従業員の情報を取得するためのメソッドを定義したインターフェースとその実装.
- **EmployControllerクラス**: REST APIのエンドポイントを提供するコントローラクラス.
- **ResourceNotFoundException**: リソースが見つからなかった場合にスローされるカスタム例外.
- **SQLデータベース**:emloyeesテーブル.サンプルで20人分用意

#### SQL記述例
```sql
INSERT INTO employees (name, birthdate, department, role, email, phone)
VALUES
("山田太郎", "1985-01-01", "営業部", "営業マネージャー", "taro.yamada@example.com", "012-3456-7890"),
("鈴木花子", "1986-02-02", "総務", "総務マネージャー", "hanako.suzuki@example.com", "098-7654-3210"),
-- 以下同様のデータを追加...
("斉藤康平", "1994-08-20", "総務", "総務マネージャー", "kohei.saito@example.com", "012-3456-7890");
```

## 使い方
#### 1. Postman を使って、以下のエンドポイントにリクエストを送信します。
- 全ての従業員を取得:
````
http://localhost:8080/employees
````
- 特定のIDの従業員を取得:
````
http://localhost:8080/employees/1
````
- 特定の部署の従業員を取得:
````
http://localhost:8080/employees/department?name=人事部
````
# 動作結果
- 全ての従業員を取得:  
id,birthdate,email,phoneの情報は含まれません.  

![image](https://github.com/yuuki-katou/raisetech_lecture9/assets/142807995/76f0af63-3dd7-4d7b-b41f-6cb2be098fd4)  

- 特定のIDの従業員を取得:  
![2023-09-01_14h55_11](https://github.com/yuuki-katou/raisetech_lecture9/assets/142807995/b24c070d-24ac-4db5-a2ce-d9824a3e2755)

- 特定の部署の従業員を取得:  
![image](https://github.com/yuuki-katou/raisetech_lecture9/assets/142807995/48b92b4e-788c-4f8d-a1bb-1d07b61fbb1e)

