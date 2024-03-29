const express = require('express');
const cors = require('cors');
const { v4: uuidv4 } = require('uuid');
const { exec } = require('child_process');
const fs = require('fs');
const path = require('path');
const app = express();

app.use(cors());
app.use(express.json());

function fileExists(filePath) {
    try {
        fs.accessSync(filePath, fs.constants.F_OK);
        return true;
    } catch (err) {
        return false;
    }
}

//serve unique front file
app.get('/', (req, res) => {
    const indexPath = path.join(__dirname, 'index.html');
    res.sendFile(indexPath);
});

app.post('/convert', (req, res) => {
    console.log(`POST /convert`)


    const jarPath = './midi-converter.jar';
    const text = req.body.text;

    //temp files
    const uniqueId = uuidv4(); //unique id to save and retrieve temp files without overwriting those of other users

    const tempFilePath = `${uniqueId}.music`;
    fs.writeFileSync(tempFilePath, text);

    //todo: generate unique file name in java
    const outputPath = `${uniqueId}.midi`;

    exec(`java -jar ${jarPath} ${tempFilePath} --generateJSON`, (error, stdout, stderr) => {
        // delete temp txt file
        fs.unlinkSync(tempFilePath);

        if (error) {
            console.error(`exec error: ${error}`);
            return res.status(500).send(stderr);
        }

        res.download(outputPath, () => {
            // delete midi file
            fs.unlinkSync(outputPath);
        });
    });
});

app.get('/getPartition', (req, res) => {
    console.log('get /getPartition');
    let tmpData = "musicDataAddon.json";
    if (fileExists(tmpData)) {
        console.log(`Le fichier existe.`);
        const jsonData = fs.readFileSync(tmpData, 'utf-8');
        const parsedData = JSON.parse(jsonData);
        // Delete partition file
        fs.unlinkSync(tmpData);
        // return json
        res.json(parsedData);
    } else {
        console.log(`Le fichier n'existe pas.`);

        return res.status(500).send('Error, generate midi first');
    }
})

app.listen(80, () => {
    console.log('Server running on port 80');
});
