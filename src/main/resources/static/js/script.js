document.addEventListener('keydown', function (event) {
  if (event.keyCode === 13 && event.target.nodeName === 'INPUT') {
    var form = event.target.form;
    var index = Array.prototype.indexOf.call(form, event.target);
   form.elements[index + 2].focus();
    event.preventDefault();
  }
});

$(function(){
            $('.js-initialValue').maskMoney({
				prefix:'R$', 
				allowNegative: false, 
				thousands:'.', 
				decimal:',', 
				affixesStay: false
			});
        })

function calcular(){
    var valor1 = parseInt(document.getElementById('ballotTwo').value, 10) * 2;
    var valor2 = parseInt(document.getElementById('ballotFive').value, 10) * 5;
    var valor3 = parseInt(document.getElementById('ballotTen').value, 10) * 10;
    var valor4 = parseInt(document.getElementById('ballotTwenty').value, 10) * 20;
    var valor5 = parseInt(document.getElementById('ballotFifity').value, 10) * 50;
    var valor6 = parseInt(document.getElementById('ballotOnehundred').value, 10) * 100;
    var valor7 = parseInt(document.getElementById('ballotTwohundred').value, 10) * 200;
    
    var total1 = valor1 + valor2 + valor3 + valor4 + valor5 + valor6 + valor7;
    
    var valor8 = parseFloat(document.getElementById('coinFivecents').value, 10) * 0.05;
    var valor9 = parseFloat(document.getElementById('coinTencents').value, 10) * 0.10;
    var valor10 = parseFloat(document.getElementById('coinTwentyfivecents').value, 10) * 0.25;
    var valor11 = parseFloat(document.getElementById('coinFifitycents').value, 10) * 0.5;
    var valor12 = parseFloat(document.getElementById('coinOne').value, 10);
    
    var total2 = valor8 + valor9 + valor10 + valor11 + valor12;
    
    var total3 = total1 + total2;
    
    document.getElementById('totalCoins2').value = total2.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
    document.getElementById('totalBallots2').value = total1.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
    document.getElementById('totalFinal').value = total3.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});

    document.getElementById('totalCoins').value = total2;
    document.getElementById('totalBallots').value = total1;
}

