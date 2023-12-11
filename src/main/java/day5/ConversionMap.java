package day5;

public record ConversionMap (long sourceStart, long targetStart, long size){

    public long convertFromSourceToTarget(long source){
        return targetStart + (source - sourceStart);
    }

    public long convertFromTargetToSource(long target){
        return sourceStart + (target - targetStart);
    }

    public boolean isInSourceRange(long source){
        return source >= sourceStart && source < sourceStart + size;
    }

    public boolean isInTargetRange(long target){
        return target >= targetStart && target < targetStart + size;
    }

    public static ConversionMap fromLine(String line){
        String[] parts = line.split(" ");
        long sourceStart = Long.parseLong(parts[1].trim());
        long targetStart = Long.parseLong(parts[0].trim());
        long size = Long.parseLong(parts[2].trim());
        return new ConversionMap(sourceStart, targetStart, size);
    }
}
