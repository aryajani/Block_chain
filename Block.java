import java.util.Date;

public class Block{
    
    public String hash;             //digital fingerprint (of the current block)
    public String prev_hash;        //digital fingerprint (of the previous block)
    public String data;             // data of the block
    private long time_stamp;        // numeber of milliseconds since 1/1/1970

    //contructor
    public Block(String data, String prev_hash){
        this.prev_hash = prev_hash;
        this.data = data;
        this.time_stamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // calculates the hash based on the previous hash, timeStamp, and data
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256( 
                prev_hash +
                Long.toString(time_stamp) +
                data 
                );
        return calculatedhash;
    }

    // checks if hashes are correct by using the SHA-256 formula
    public boolean checkChain(){
        boolean result = true;
        Block currBlock;
        Block prevBlock;

        for (int i = 1; i < block_chain.blockchain.size(); i++){
            currBlock = block_chain.blockchain.get(i);
            prevBlock = block_chain.blockchain.get(i-1);
            if (currBlock.hash != currBlock.calculateHash()){
                result = false;
            }
            if (prevBlock.hash != prevBlock.calculateHash()){
                result = false;
            }
        }
        
        return result;
    }
}