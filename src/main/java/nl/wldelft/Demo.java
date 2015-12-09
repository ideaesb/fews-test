package main.java.nl.wldelft;

import java.io.File;
import javax.xml.bind.*;
import nl.wldelft.fews.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(TimeSeriesCollectionComplexType.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        String timeSeriesXML = "/Users/udaykari/Documents/workspace/ens2csv/ensts/UnReg/ACJU1L_F.SIM24.SQME.24.CS.xml";
        TimeSeriesCollectionComplexType timeSeries = 
        		(TimeSeriesCollectionComplexType) unmarshaller.unmarshal(new File(timeSeriesXML));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(timeSeries, System.out);
    }

}