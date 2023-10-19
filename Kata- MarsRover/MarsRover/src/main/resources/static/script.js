createMap();


async function createMap() {
  //Obtener la informacion del rover
  refreshRover();
  //accedemos al objeto que trae de la solicitud fetch
  //Obtener la info de los obstaculos
  let obstacleResponse = await fetch('http://localhost:8080/api/obstacle/', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  });
  //recorre el objeto y accede a cada una de las posiciones creando una roca
  let obstaclesJson = await obstacleResponse.json();
  obstaclesJson.forEach(obstacleJson => {
    createRock(obstacleJson.x, obstacleJson.y);
  });

}

async function refreshRover() {
  //Obtener la informacion del rover
  let roverResponse = await fetch('http://localhost:8080/api/rover/', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  });
  let roverJson = await roverResponse.json();
  moveRover(roverJson.x, roverJson.y);
}



function moveRover(x, y) {
  document.getElementById('rover').style.top = (y * 100) + 'px';
  document.getElementById('rover').style.left = (x * 100) + 'px';
  playMoveSound();
}


function createRock(x, y) {
  var rock = document.createElement('img');
  rock.setAttribute('src', 'images/rock.png');
  rock.setAttribute('class', 'rock');
  var container = document.getElementById('container');
  container.appendChild(rock);
  rock.style.top = (y * 100) + 'px';
  rock.style.left = (x * 100) + 'px';
}


var posX = 0;
var posY = 0;

function clickBtnLeft() {
    sendCommand("L");
}

async function clickBtnUp() {
    sendCommand("F")
}

async function sendCommand(command) {
  let requestBody = {
    "commands": [command]
  }

  let roverResponse = await fetch('http://localhost:8080/api/rover/command/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(requestBody)
  });
  await refreshRover();

}


function clickBtnDown() {
    sendCommand("B");
}



function clickBtnRight() {
    sendCommand("R");
}

function playMoveSound() {
  var audioElement = document.createElement('audio');
  audioElement.src = 'sounds/move1.mp3';
  audioElement.controls = true;
  audioElement.autoplay = true;

  document.getElementById('container').appendChild(audioElement);
}