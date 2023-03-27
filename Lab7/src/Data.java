import java.util.ArrayList;
import java.lang.Math.*;
public class Data {
    String term;
    ArrayList<Double> termFrequencys;
    double idf;

    public Data(String Term,ArrayList<Double>TermFrequencys, double Idf){
     term=Term;
     termFrequencys=TermFrequencys;
     idf=Idf;
    }
    public static void main(String[]args){
        String[] documents = 
        {"I want happy music to bring me power",
         "I like happy music because happy music bring me power",
         "I need power because it makes me happy to have power",
         "I need to bring the music to the happy house to i can bring it back home",
         "music music music music music music music music music boa"};
        ArrayList<String[]> tokenizedDocuments = new ArrayList<String[]>();
        for(int i=0;i<documents.length;i++){
            tokenizedDocuments.add(documents[i].split(" "));
        }
        String query =  "happy music bring power boa";
        String[] terms = query.split(" ");
        ArrayList<Data> dataList= new ArrayList<Data>();
        for(String term:terms){
            dataList.add(new Data(term,new ArrayList<Double>(),0.0));
        }
        int termFrequency=0;
        int inverseDocumentfrequency=0;
        boolean found=false;
        int i=0,j=0,k=0;
        for(;i<=dataList.size();i++){
            //documents idf calculated here

            if(i>=1){
            (dataList.get(i-1)).idf=Math.log(tokenizedDocuments.size()/inverseDocumentfrequency);
            }
            inverseDocumentfrequency=0;
               
            for(j=0;i<dataList.size()&&j<=tokenizedDocuments.size();j++){
                //tokenized documents

                if(j>=1){
                (dataList.get(i)).termFrequencys.add((double)termFrequency/((tokenizedDocuments.get(j-1))).length);
                }
                if(found==true){
                    inverseDocumentfrequency++;
                }
    
                found=false;
                termFrequency=0;

                for(k=0;j<tokenizedDocuments.size() && k<tokenizedDocuments.get(j).length;k++){
                    if((tokenizedDocuments.get(j))[k].compareToIgnoreCase((dataList.get(i)).term)==0){
                        found=true;
                        termFrequency++;
                   
                  }
                    
                }
            }
        }
        for(Data d:dataList){
            System.out.printf("Term: %s\nIDF:%f\n", d.term,d.idf);
            for(Double frequency: d.termFrequencys){
                System.out.println(frequency);
            }
        }
    }
}
