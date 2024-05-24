// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyANq5gccfu7i5d6JVNUE8Uw8YSKIvJUZko",
  authDomain: "db-github-11ca8.firebaseapp.com",
  projectId: "db-github-11ca8",
  storageBucket: "db-github-11ca8.appspot.com",
  messagingSenderId: "236802727820",
  appId: "1:236802727820:web:27b36c651eb849c1ed40a9",
  measurementId: "G-CYR5VZ24PX"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);