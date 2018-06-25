--最近一小时的数据

SELECT
  ctp.INSTRUMENT_ID,
  ctp.UPDATE_TIME,
  DATE_FORMAT(
    CONCAT(
      DATE_FORMAT(NOW(), '%y-%m-%d '),
      ctp.UPDATE_TIME
    ),
    '%y-%m-%d %H:%i:%s'
  ) AS format_date
FROM
  ba_ctp_futures_depth_market_data ctp
WHERE
  TO_DAYS(ctp.LAST_UPD_DATE) = TO_DAYS(NOW())
AND ctp.INSTRUMENT_ID = 'sn1902'
AND DATE_FORMAT(
  CONCAT(
    DATE_FORMAT(NOW(), '%y-%m-%d '),
    ctp.UPDATE_TIME
  ),
  '%y-%m-%d %H:%i:%s'
) BETWEEN NOW()-INTERVAL 1 HOUR
AND NOW();