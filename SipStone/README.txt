   1.  On 172.25.58.147, in ~adrian/Mockphones: /opt/jdk1.5.0_13/bin/java -jar Mockphones.jar to start up the stack. Ensure that Mockphones has been built with the latest SSS jars.
   2. On radon195, in ~ramesh: /opt/sipp/sipp 132.146.185.195 -sf inbound2.xml -inf callees.csv -rsa 172.25.58.147:6060 -rate_increase 10 -fd 90s -rate_max 100 -trace_stat
   3. Parse resulting stat file inbound2.xml_xxxxx.csv_ and make following changes:
         1. The delimiter used in the resulting stat file is ';'. If required, replace all ';' with ','.
         2. The column headers and the corresponding data appear in the following header. Either extract the columns in bold or remove the others from the file.
               1. StartTime
               2. LastResetTime
               3. CurrentTime
               4. ElapsedTime(P)
               5. ElapsedTime(C)
               6. CallRate(P)
               7. CallRate(C)
               8. IncomingCall(P)
               9. IncomingCall(C)
              10. OutgoingCall(P)
              11. OutgoingCall(C)
              12. TotalCallCreated
              13. CurrentCall
              14. SuccessfulCall(P)
              15. SuccessfulCall(C)
              16. FailedCall(P)
              17. FailedCall(C)
              18. FailedCannotSendMessage(P)
              19. FailedCannotSendMessage(C)
              20. FailedMaxUDPRetrans(P)
              21. FailedMaxUDPRetrans(C)
              22. FailedUnexpectedMessage(P)
              23. FailedUnexpectedMessage(C)
              24. FailedCallRejected(P)
              25. FailedCallRejected(C)
              26. FailedCmdNotSent(P)
              27. FailedCmdNotSent(C)
              28. FailedRegexpDoesntMatch(P)
              29. FailedRegexpDoesntMatch(C)
              30. FailedRegexpHdrNotFound(P)
              31. FailedRegexpHdrNotFound(C)
              32. FailedOutboundCongestion(P)
              33. FailedOutboundCongestion(C)
              34. FailedTimeoutOnRecv(P)
              35. FailedTimeoutOnRecv(C)
              36. OutOfCallMsgs(P)
              37. OutOfCallMsgs(C)
              38. Retransmissions(P)
              39. Retransmissions(C)
              40. AutoAnswered(P)
              41. AutoAnswered(C)
              42. ResponseTime1(P)
              43. ResponseTime1(C)
              44. ResponseTime1StDev(P)
              45. ResponseTime1StDev(C)
              46. CallLength(P)
              47. CallLength(C)
              48. CallLengthStDev(P)
              49. CallLengthStDev(C)
              50. GenericCounter1(P)
              51. GenericCounter1(C)
              52. GenericCounter2(P)
              53. GenericCounter2(C)
              54. GenericCounter3(P)
              55. GenericCounter3(C)
              56. GenericCounter4(P)
              57. GenericCounter4(C)
              58. GenericCounter5(P)
              59. GenericCounter5(C)
              60. ResponseTimeRepartition1;
              61. <10
              62. <20
              63. <30
              64. <40
              65. <50
              66. <100
              67. <150
              68. <200
              69. >=200
              70. CallLengthRepartition
              71. <10
              72. <50
              73. <100
              74. <500
              75. <1000
              76. <5000
              77. <10000
              78. >=10000
   4. The resultant file can be opened in Excel to view formatted results, or can be converted to other suitable representable format.
