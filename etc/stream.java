package etc;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class stream {

    ArrayList<String> fruits = new ArrayList<>();
    fruits.add(0, "apple");// 순서 보장 & 중복 허용

    Set<String> sweets = new HashSet<>(); // 순서 보장 X

    List<String> orderList = ["apple", "banana", "kiwi"]
            .stream()
            .filter
            .collect(Collectors.toList());

    Set<String> orderIds = orderList.stream()
            .map()
            .collect(Collectors.toSet());


    return orderIds.stream()
            .map(orderId -> {
        List<CoupangPostbackVo> order = coupangPostbackService.getOrderList(mbrId, orderId);
        List<CoupangPostbackVo> purchaseList = order.stream()
                .filter(CoupangPostbackVo::isPurchase)
                .collect(Collectors.toList());

        List<CoupangStampVoV2> stamps = coupangStampService.getStamps(mbrId, orderId);

        int stampCount = stamps.size();
        int canceledCount = (int) stamps.stream()
                .filter(stamp -> Status.F == stamp.getStatus())
                .count();

        List<CoupangPostbackVo> canceledList = order.stream()
                .filter(CoupangPostbackVo::isCancel)
                .collect(Collectors.toList());

        OrderHistoryVo purchaseHistory = OrderHistoryVo.builder()
                .orderedAt(
                        LocalDateTime.parse(
                                purchaseList.get(0).getCreatedAt(),
                                OrderHistoryVo.commonDateFormatter
                        )
                )
                .status(Status.S)
                .productName(
                        purchaseList.size() > 1
                                ? purchaseList.get(0).getProductName() + " 외 " + (purchaseList.size()
                                - 1) + "건"
                                : purchaseList.get(0).getProductName()
                )
                .stampCount(stampCount)
                .price(
                        purchaseList.stream()
                                .mapToInt(CoupangPostbackVo::getUnitPrice)
                                .sum()
                )
                .build();

        OrderHistoryVo canceledHistory = !canceledList.isEmpty()
                ?
                OrderHistoryVo.builder()
                        .orderedAt(
                                LocalDateTime.parse(
                                        canceledList.get(0).getCreatedAt(),
                                        OrderHistoryVo.commonDateFormatter
                                )
                        )
                        .status(Status.F)
                        .stampCount(canceledCount)
                        .productName(
                                canceledList.size() > 1
                                        ? canceledList.get(0).getProductName() + " 외 " + (
                                        canceledList.size() - 1) + "건"
                                        : canceledList.get(0).getProductName()
                        )
                        .price(
                                canceledList.stream()
                                        .mapToInt(CoupangPostbackVo::getUnitPrice)
                                        .sum()
                        )
                        .build()
                : null;

        return Arrays.asList(
                purchaseHistory,
                canceledHistory
        );
    })
            .sorted((a, b) -> {
        int dateCmp = a.get(0).getOrderedAt().compareTo(b.get(0).getOrderedAt());
        if (dateCmp != 0) {

            return dateCmp;

        }

        Integer aPrice = a.get(0).getPrice();
        Integer bPrice = b.get(0).getPrice();
        return aPrice.compareTo(bPrice);
    })
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

}
