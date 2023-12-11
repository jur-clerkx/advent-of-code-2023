package day5;

import java.util.List;

public record ConversionGroup (List<ConversionMap> conversionMaps) {
        public long convertFromSourceToTarget(long source){
            return conversionMaps.stream()
                    .filter(conversionMap -> conversionMap.isInSourceRange(source))
                    .findFirst()
                    .map(conversionMap -> conversionMap.convertFromSourceToTarget(source))
                    .orElse(source);
        }

        public long convertFromTargetToSource(long target){
            return conversionMaps.stream()
                    .filter(conversionMap -> conversionMap.isInTargetRange(target))
                    .findFirst()
                    .map(conversionMap -> conversionMap.convertFromTargetToSource(target))
                    .orElse(target);
        }

        public static ConversionGroup fromLines(List<String> lines){
            return new ConversionGroup(lines.stream().map(ConversionMap::fromLine).toList());
        }
}
