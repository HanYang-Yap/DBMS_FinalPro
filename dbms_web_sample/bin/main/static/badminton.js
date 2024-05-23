$(document).ready(function () {
    // 初始化FullCalendar
    $('#badmintonCalendar').fullCalendar({
        events: '/api/events', // 初次加載時的活動數據
    });

    function fetchLatestNotices() {
        $.ajax({
            url: '/api/notifications',
            type: 'GET',
            success: function (notices) {
                $('.contentNoti').empty();
                notices.forEach(function (notice) {
                    $('.contentNoti').append(`
                        <div class="notice" style="display: flex; align-items: center; margin-bottom: 10px;">
                        <span style="margin-right: 10px;">${notice.pinned ? '📌' : ''}</span>
                        <span style="flex-grow: 1;">${notice.content}</span>
                        <span style="margin-left: 10px;"><small>${notice.date}</small></span>
                        </div>
                    `);
                });
            },
            error: function () {
                alert('Error fetching latest notices. Please try again.');
            }
        });
    }

    // 函數：刷新FullCalendar活動
    function refreshCalendarEvents() {
        $('#badmintonCalendar').fullCalendar('refetchEvents');
    }

    // 定期更新最新通知（例如每60秒更新一次）
    setInterval(fetchLatestNotices, 60000);

    // 定期刷新日曆活動（例如每60秒刷新一次）
    setInterval(refreshCalendarEvents, 60000);

    // 頁面加載時先執行一次
    fetchLatestNotices();
    refreshCalendarEvents();
});