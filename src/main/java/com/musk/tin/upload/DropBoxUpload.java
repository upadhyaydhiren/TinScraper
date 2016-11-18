package com.musk.tin.upload;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.musk.tin.model.TinDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.LocalDateTime;

/**
 * This class is used for upload scraped details in dropbox
 * Created by dhiren on 17/11/16.
 * @author dhiren
 * @since 17-11-2016
 */
public class DropBoxUpload {
    private static final String ACCESS_TOKEN = "4E6F22YA0WoAAAAAAAABHoil0ihmzoZKsSHNPe-GZ7Y_BEe97COMA6fBwaeFaHE7";

    private static final String COMMA_DELIMITED = ",";

    final String FILE_HEADER = "tin,cstNumber,dealerName,dealerAddress,stateName,panNumber,dateOfRegistration,status,validAsOn";

    private final DbxClientV2 client;

    private TinDetails tinDetails;

    private FileWriter writer = null;

    private  File file = null;

    public DropBoxUpload(TinDetails tinDetails) throws Exception {
        this.tinDetails = tinDetails;
        DbxRequestConfig config = new DbxRequestConfig("dropbox/Musk");
        this.client = new DbxClientV2(config,ACCESS_TOKEN);
        csvRight();
    }

    public boolean isUpload() throws Exception {
        try {
            String timeStamp = LocalDateTime.now().toString();
            client.files().createFolder("/"+timeStamp);
             file = new File("/tmp/tindetails.csv");
            FileInputStream inputStream = new FileInputStream(file);
            client.files().uploadBuilder("/"+timeStamp+"/tindetails.csv")
                    .uploadAndFinish(inputStream);
            return true;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally {
            assert file != null;
            file.delete();
        }
    }

    private void csvRight() throws Exception
    {
        try {
            writer = new FileWriter("/tmp/tindetails.csv");
            writer.append(FILE_HEADER);
            writer.append("\n");
            writer.append(tinDetails.getTin());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getCstNumber());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getDealerName());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getDealerAddress());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getStateName());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getPanNumber());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getDateOfRegistration());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getStatus());
            writer.append(COMMA_DELIMITED);
            writer.append(tinDetails.getValidAsOn());
            writer.append("\n");

        } catch (Exception e) {
            throw e;
        }
        finally {
            try {
                assert writer != null;
                writer.flush();
                writer.close();
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
