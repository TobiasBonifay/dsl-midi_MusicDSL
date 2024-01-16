const express = require('express');
const cors = require('cors');
const multer = require('multer');
const { exec } = require('child_process');
const app = express();
const upload = multer({ dest: 'uploads/' });

app.use(cors());

app.post('/convert', upload.single('textFile'), (req, res) => {
    const jarPath = './midi-converter.jar';
    const inputPath = req.file.path;
    const outputPath = inputPath + '.midi';

    exec(`java -jar ${jarPath} ${inputPath}`, (error, stdout, stderr) => {
        if (error) {
            console.error(`exec error: ${error}`);
            return res.status(500).send('Error during file conversion');
        }
        res.download(outputPath);
    });
});

app.listen(80, () => {
    console.log('Server running on port 80');
});
