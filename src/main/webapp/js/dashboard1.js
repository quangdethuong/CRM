 Morris.Bar({
    element: 'morris-area-chart2',
    data: [
        { label: 'CHƯA BẮT ĐẦU', value: 23 },
        { label: 'ĐANG THỰC HIỆN', value: 169 },
        { label: 'ĐÃ HOÀN THÀNH', value: 157 }
    ],
    xkey: 'label',
    ykeys: ['value'],
    labels: ['Số lượng'],
    barColors: ['#e74c3c', '#00bcd4', '#2196f3']
});

$(".counter").counterUp({
    delay: 100,
    time: 1200
});
