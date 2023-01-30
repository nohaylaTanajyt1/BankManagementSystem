package Modele.gestionBanque;
import java.util.Date;

/**
 * author nohayla
 * version 1
 * 
 */ 
public class ModelListerVirement {


    private long num_c_ben;
    private long num_op;
    private Date date_op;
    private Double mnt_op;
    private long num_c_em;

	/**
     * Effectuer un virement
     * 
     */

    public ModelListerVirement(long num_op, Date date_op, Double mnt_op,long num_c_em,long num_c_ben) {
    
        this.num_c_ben = num_c_ben;
        this.num_op = num_op;
        this.date_op = date_op;
        this.mnt_op = mnt_op;
        this.num_c_em = num_c_em;
    }
    public long getNum_c_em() {
        return num_c_em;
    }

    public long getNum_op() {
        return num_op;
    }

    public Date getDate_op() {
        return date_op;
    }

    public Double getMnt_op() {
        return mnt_op;
    }

    public long getNum_c_ben() {
        return num_c_ben;
    }

    public void setNum_c_ben(long num_c_ben) {
        this.num_c_ben = num_c_ben;
    }
}

    

