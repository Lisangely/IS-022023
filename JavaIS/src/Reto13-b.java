import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.*;

class Teacher{
    String ci ="NO";
    int ct;
    double mu;
    boolean visit;
    int num;

    Teacher(String ci, int ct, double mu, int n){
        this.ci = ci;
         this.ct = ct;
          this.mu = mu;
        this.visit=true;
        num=n;
    }
    int numm(){
        return num;
    }
    int getCt(){
        return ct;
    }
    double getMu(){
        return mu;
    }
    boolean Visit(){
        return visit;
    }
    void Visited(){
        visit=false;
    }
    String name(){
        return ci;
    }
}
class Data{
    String desc;
    int ct;
    double mu;
    int dd;
    int mm;
    int aaaa;
    String nf;
    String ci;

    public Data(String desc, int ct,double mu, int dd, int mm, int aaaa, String nf,String ci){
        this.desc = desc;
        this.ct=ct;
        if(dd>=1 && dd<=31){
        this.dd=dd;
        }
        if(mm>=1 && mm<=31){
        this.mm=mm;
        }
        if(aaaa>=1968){
        this.aaaa=aaaa;
        }
        this.nf = nf;
        this.ci=ci;
    }
    int getCt(){
        return ct;
    }
    double getMu(){
        return mu;
    }
    String getCi(){
        return ci;
    }
}

class B {
    public static void main(String[] args) throws Exception {
       int lines = 0;
		try {
			FileReader fr = new FileReader("src/inventario.txt");
			BufferedReader bf = new BufferedReader(fr);
			while ((bf.readLine())!=null) {
			  lines++;
			}
		} catch (FileNotFoundException fnfe){
			  fnfe.printStackTrace();
		} catch (IOException ioe){
		  ioe.printStackTrace();
		}
        Teacher teachers[] = new Teacher[lines];
        Data datas[] = new Data[lines];
        
        File archive = new File ("src/inventario.txt");
        FileReader fr = new FileReader (archive);
        BufferedReader br = new BufferedReader(fr);

        for(int i=0; i<lines;i++){
            String input = br.readLine().trim();
            String[] parts = input.split("#");
                String desc = parts[0].trim();
                //System.out.println(desc);
                int ct = Integer.parseInt(parts[1].trim());
                double mu = Double.parseDouble(parts[2].trim());
                String[] fechaParts = parts[3].trim().split("/");
                int dd = Integer.parseInt(fechaParts[0]);
                int mm = Integer.parseInt(fechaParts[1]);
                int aaaa = Integer.parseInt(fechaParts[2]);
                String nf = parts[4].trim();
                String ci = parts[5].trim();
        datas[i] = new Data(desc, ct, mu, dd, mm, aaaa, nf, ci);
        teachers[i]= new Teacher(ci, ct, mu, i);
        }
        double summary=0;
        String ruta = "src/reporte.txt";
        int totality=0;
        try { File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
               for(int i=0; i<lines;i++){
                 String name = teachers[i].name();
                 if(teachers[i].Visit()){
                    bw.write(teachers[i].name());
                    teachers[i].Visited();
                    totality += teachers[i].getCt();
                    summary += (teachers[i].getMu()*teachers[i].getCt());
                    int name1= Integer.valueOf(name);
                         for(int j=0; j<lines;j++){
                              int name2= Integer.valueOf(teachers[j].name());
                            if((name1==name2) && (teachers[j].Visit())){   
                            teachers[j].Visited();
                            totality += teachers[j].getCt();
                            summary += (teachers[j].getMu()*teachers[j].getCt());
                            }
                            if(j==lines-1){
                                bw.write(totality);
                                String BS = String.valueOf(summary);
                                bw.write(BS);
                                bw.newLine();
                                totality=0;
                                summary=0;
                        }
                    }
                }
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
        br.close();
        
 }
}