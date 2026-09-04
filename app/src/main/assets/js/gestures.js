var app = {
    inicio: function () {
        this.iniciaBotones();
    },

    iniciaBotones: function () {
        var botonPlay = document.querySelector('#play');
        var botonPause = document.querySelector('#pausa');
        var botonVolMas = document.querySelector('#volumemas');
        var botonVolMenos = document.querySelector('#volumemenos');

        if (botonPlay) botonPlay.addEventListener('click', app.play, false);
        if (botonPause) botonPause.addEventListener('click', app.pausa, false);
        if (botonVolMas) botonVolMas.addEventListener('click', app.subeVol, false);
        if (botonVolMenos) botonVolMenos.addEventListener('click', app.bajaVol, false);
    },

    play: function () {
        document.getElementById('emisora').play();
    },

    pausa: function () {
        document.getElementById('emisora').pause();
    },

    subeVol: function () {
        var radio = document.getElementById('emisora');
        radio.volume = Math.min(1.0, radio.volume + 0.1);
    },

    bajaVol: function () {
        var radio = document.getElementById('emisora');
        radio.volume = Math.max(0.0, radio.volume - 0.1);
    }
};

document.addEventListener('DOMContentLoaded', function () {
    app.inicio();
}, false);