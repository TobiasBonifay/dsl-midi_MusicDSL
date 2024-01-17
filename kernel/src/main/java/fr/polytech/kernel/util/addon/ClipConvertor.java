package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.util.addon.models.MusicData;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ClipConvertor {

    public void convertClipToJSON(Clip clip) {
        MusicData musicData = new MusicData();

        for (Bar bar : clip.getBars()){
            //todo
        }

        // Serialize to JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            String json = objectMapper.writeValueAsString(musicData);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
