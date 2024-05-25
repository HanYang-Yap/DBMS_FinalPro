// Get the current date
var currentDate = new Date().toLocaleString();

// Concatenate "Login time:" with the date string
var dateTimeString = "(登入時間) " + currentDate;

// Set the concatenated string as the inner HTML of the div
document.getElementById("current_date").innerHTML = dateTimeString;

// Firebase 配置信息
const firebaseConfig = {
  apiKey: "YOUR_API_KEY",
  authDomain: "YOUR_AUTH_DOMAIN",
  databaseURL: "YOUR_DATABASE_URL",
  projectId: "YOUR_PROJECT_ID",
  storageBucket: "YOUR_STORAGE_BUCKET",
  messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
  appId: "YOUR_APP_ID",
};

// 初始化 Firebase
firebase.initializeApp(firebaseConfig);

// 获取数据库引用
const database = firebase.database();

// 监听表单提交事件
document.getElementById("myForm").addEventListener("submit", submitForm);

function submitForm(e) {
  e.preventDefault();

  // 获取表单数据
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;

  // 写入数据库
  writeUserData(name, email);
}

function writeUserData(name, email) {
  const newUserRef = database.ref("users").push();
  newUserRef
    .set({
      name: name,
      email: email,
    })
    .then(() => {
      alert("Data submitted successfully!");
    })
    .catch((error) => {
      console.error("Error writing to Firebase Database", error);
    });
}
