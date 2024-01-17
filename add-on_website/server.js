const express = require('express');
const cors = require('cors');
const { v4: uuidv4 } = require('uuid');
const { exec } = require('child_process');
const fs = require('fs');
const path = require('path');
const app = express();

app.use(cors());
app.use(express.json());

//serve unique front file
app.get('/', (req, res) => {
    const indexPath = path.join(__dirname, 'index.html'); // Remplacez 'chemin/vers/index.html' par le chemin réel de votre fichier index.html
    res.sendFile(indexPath);
});

app.post('/convert', (req, res) => {
    console.log(`POST /convert`)


    const jarPath = './midi-converter.jar';
    const text = req.body.text;

    //temp files
    const uniqueId = uuidv4();

    const tempFilePath = `${uniqueId}.txt`;
    fs.writeFileSync(tempFilePath, text);

    //todo: generate unique file name in java
    const outputPath = `test.midi`;

    exec(`java -jar ${jarPath} ${tempFilePath}`, (error, stdout, stderr) => {
        // delete temp txt file
        fs.unlinkSync(tempFilePath);

        if (error) {
            console.error(`exec error: ${error}`);
            return res.status(500).send('Error during file conversion');
        }

        res.download(outputPath, () => {
            // delete midi file
            fs.unlinkSync(outputPath);
        });
    });
});

app.listen(80, () => {
    console.log('Server running on port 80');
});
