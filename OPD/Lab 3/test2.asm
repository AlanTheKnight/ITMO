    ORG 0x100
sumHead: WORD 0x0000
sumTail: WORD 0x0000
max: WORD 0x8000
maxImmutable: WORD 0x8000
firstElementAddress: WORD 0x500
currentElementAddress: WORD 0x0000
arrayLength: WORD 0x0009
numberOfElementsLeft: WORD 0x0000
currentRow: WORD 0x0000


    ORG 0x110
Start: CLA
    CALL Reset
    MainLoop: LD (currentElementAddress)+
        CMP currentRow
        BEQ Continue1
        UpdateRow: ST currentRow
            LD max
            PUSH
            CALL Addition
            POP
            LD maxImmutable
            ST max
        Continue1: LD (currentElementAddress)+
            CMP max
            BLT Continue2
        UpdateMaximum: ST max
        Continue2: LOOP numberOfElementsLeft
            JUMP MainLoop
        LD max
        PUSH
        CALL Addition
        POP
HLT


    ORG 0x130
Reset: CLA
    ST sumHead
    ST sumTail
    LD #0x1
    ST currentRow
    LD firstElementAddress
    ST currentElementAddress
    LD arrayLength
    ST numberOfElementsLeft
    LD maxImmutable
    ST max
    ResestReturn: RET

Addition: LD &1
    ADD sumTail
    ST sumTail
    LD &1
    BMI Negative
    Positive: LD sumHead
        ADC #0x00
        JUMP AdditionReturn
    Negative: LD sumHead
        ADC #0xFF
    AdditionReturn: ST sumHead
        RET


    ORG 0x500
WORD 0x0001
WORD 0xFFF7
WORD 0x0001
WORD 0x2308
WORD 0x0001
WORD 0x3309
WORD 0x0002
WORD 0x1003
WORD 0x0002
WORD 0x0004
WORD 0x0002
WORD 0x0005
WORD 0x0003
WORD 0xF000
WORD 0x0003
WORD 0xF001
WORD 0x0003
WORD 0xF124
