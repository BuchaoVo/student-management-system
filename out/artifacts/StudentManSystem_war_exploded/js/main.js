'use strict';

const cardLength = document.querySelectorAll('.card').length;
const cardHeader = document.querySelectorAll('.card_header');
console.log(cardLength, cardHeader);
for (let i = 0; i < cardLength; i++) {
    const cardHeaderUrl = cardHeader[i].getAttribute('data-background');
    cardHeader[i].style.background = 'url(' + cardHeaderUrl + ')no-repeat center center / cover';
}