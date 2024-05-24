console.log('JavaScript file is loaded correctly.');

import { initializeApp } from "https://www.gstatic.com/firebasejs/10.12.0/firebase-app.js";
import { getDatabase, ref, onValue } from "https://www.gstatic.com/firebasejs/10.12.0/firebase-database.js";

const firebaseConfig = {
    apiKey: "AIzaSyANq5gccfu7i5d6JVNUE8Uw8YSKIvJUZko",
    authDomain: "db-github-11ca8.firebaseapp.com",
    databaseURL: "https://db-github-11ca8-default-rtdb.asia-southeast1.firebasedatabase.app",
    projectId: "db-github-11ca8",
    storageBucket: "db-github-11ca8.appspot.com",
    messagingSenderId: "236802727820",
    appId: "1:236802727820:web:27b36c651eb849c1ed40a9",
};

const app = initializeApp(firebaseConfig);
const db = getDatabase(app);

$(document).ready(function () {
    function setupRealtimeNotices() {
        const noticesRef = ref(db, '/notifications');

        onValue(noticesRef, (snapshot) => {
            const notices = snapshot.val();
            $('.contentnoti').empty();
            for (let key in notices) {
                if (notices.hasOwnProperty(key)) {
                    const notice = notices[key];
                    $('.contentnoti').append(`
                        <div class="notice" style="display: flex; align-items: center; margin-bottom: 10px;">
                            <span style="margin-right: 10px;">${notice.Pin ? '📌' : ''}</span>
                            <span style="flex-grow: 1;">${notice.Context}</span>
                            <span style="margin-left: 10px;"><small>${notice.Sent_date}</small></span>
                        </div>
                    `);
                }
            }
        }, (error) => {
            console.error("Error fetching notices: ", error);
            alert('Error fetching latest notices. Please try again.');
        });
    }
    
    // 頁面加載時先執行一次
    setupRealtimeNotices();
});