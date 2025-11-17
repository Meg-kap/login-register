# 🌐 Webアプリケーション開発ポートフォリオ（Java / JSP / Servlet）

## 📘 概要
Java / JSP / Servlet / SQL を用いて開発した Web アプリケーションです。  
ユーザー管理・データ登録・検索などの CRUD 処理を実装し、MVC 設計と DB 連携を学習目的で作成しました。

---

## 🛠 開発環境
| 項目 | 内容 |
|------|------|
| 言語 | Java（JDK 17 など） |
| フレームワーク | Servlet / JSP（Jakarta EE） |
| データベース | MySQL 8.0 |
| ビルドツール | Apache Maven または Eclipse Dynamic Web Project |
| アプリケーションサーバー | Apache Tomcat 10.x |
| IDE | Eclipse / IntelliJ IDEA / VS Code |
| バージョン管理 | Git / GitHub |
| OS | macOS / Windows |

---

## 🧩 機能一覧
| カテゴリ | 内容 |
|------------|------|
| ユーザー管理 | 新規登録・ログイン・ログアウト・パスワード変更 |
| データ登録 | フォーム入力によるデータ追加・バリデーション処理 |
| データ検索 | キーワード検索・絞り込み検索・一覧表示 |
| 更新／削除 | 登録データの編集・削除機能 |
| セッション管理 | ログインユーザー情報の保持とアクセス制御 |
| エラーハンドリング | 例外処理／404ページ／入力エラーメッセージ表示 |

---

## 📂 ディレクトリ構成（例）
```
login-register/
├── src/main
│    ├── java/
│    │   ├── model/
│    │   │   ├── LoginLogic.java
│    │   │   ├── RegisterUserLogic.java
│    │   │   └── User.java
│    │   └── servlet/
│    │       ├── Login.java
│    │       └── RegisterUser.java
│    └── webapp/
│        ├── WEB-INF
│        │   ├── jsp
│        │   │    ├── mypage.jsp
│        │   │    ├── registerConfirm.jsp
│        │   │    ├── registerDone.jsp
│        │   │    └── registerForm.jsp
│        │   └── lib
│        │        └── h2-2.3.232.jar
│        ├── css/style.css
│        └── index.jsp
└── README.md
```

---

## 🗄 データベース構成
### 📘 ER図
> 画像を `docs/er_diagram.png` に差し替えてください。  
> 例：  
> ![ER図](./docs/er_diagram.png)

### テーブル定義例：ec_users
| カラム名         | 型            | 説明                  |
|-----------------|---------------|----------------------|
| id              | INT           | 主キー(AUTO_INCREMENT) |
| name_sei        | VARCHAR(50)   | 姓                    |
| name_mei        | VARCHAR(50)   | 名                    |
| name_sei_kana   | VARCHAR(50)   | 姓(カナ)              |
| name_mei_kana   | VARCHAR(50)   | 名(カナ)              |
| gender          | VARCHAR(10)   | 性別                  |
| email           | VARCHAR(100)  | メールアドレス        |
| mobile          | VARCHAR(20)   | 電話番号              |
| post            | VARCHAR(10)   | 郵便番号              |
| pref            | VARCHAR(20)   | 都道府県              |
| address         | VARCHAR(200)  | 住所                  |
| password        | VARCHAR(255)  | パスワード            |



---

## 🧠 設計方針・工夫点
- MVC設計：Servlet（Controller）、DAO（Model）、JSP（View）を分離
- SQLインジェクション対策として **PreparedStatement** を使用
- パスワードは **ハッシュ化（SHA-256 / bcrypt）** して保存
- JSP include によるヘッダー・フッターの共通化
- ER図・シーケンス図を用いて処理を明確化

---

## 📊 UML / 設計資料
> 以下のファイルを差し替えてください（今はプレースホルダー画像です）：
>
> - `docs/usecase.png`：ユースケース図  
> - `docs/uml_sequence.png`：シーケンス図  
> - `docs/class_diagram.png`：クラス図  
>
> 例：  
> ![シーケンス図](./docs/uml_sequence.png)

---

## 💬 使用技術のポイント
- **Servlet & JSP**：HTTPリクエスト処理・セッション管理・リダイレクト制御  
- **DAOパターン**：DB操作の共通化・保守性向上  
- **SQL**：CRUD・JOIN・トランザクション  
- **HTML/CSS**：UI / フォーム入力補助  
- **Tomcat**：WARデプロイ・ローカルテスト環境構築  

---

## 🧭 今後の拡張予定
- Bootstrap / Vue.js の導入でUI改善  
- REST API 化（JSON対応）  
- Docker による環境構築自動化  
- ログイン履歴・アクセスログの分析機能追加  
- JUnit / Mockito による単体テストの充実  

---

## 📸 画面キャプチャ（例）
> - `docs/login_screen.png`  
> - `docs/list_screen.png`  
>
> 例：  
> ![ログイン画面](./docs/login_screen.png)

---

## 🧾 ライセンス・著作権
このプロジェクトは学習目的で作成したものであり、商用利用は想定していません。  
各種ライブラリ・ツールのライセンスはそれぞれの作者に帰属します。

---

## 👤 作成者
- **氏名（またはGitHubアカウント）**：Your Name  
- **開発期間**：2025年○月〜○月  
- **連絡先**：your-email@example.com  
- **GitHub**：https://github.com/yourname/java-webapp-portfolio

---

## ✅ 最終更新日
2025-11-11

---

> ✏️ **編集方法**：VS Code / Typora などの Markdown 対応エディタで開くと、見出しや画像をプレビューできます。
