---

#### 简化版德州扑克（与题目一致）

---



#### **规则说明**

对于牌类型的判断，以尽量大的类型为标准。如对于有**四张相同数字**的手牌，将其类型判断为**三条**，而不是**两对**。





#### **输入格式**

```markdown
Black: `2H 3D 5S 9C KD` White: `2C 3H 4S 8C AH`
```

- 先Black，后White
- 两个 **抑音符(`)** 间包含五张牌内容
- 每张牌以空格分隔



#### **测试说明**

*前4个case为题目中的样例，其余case为根据规则对未测试地方的完善。*

`Case1`: 散牌间的比较

```markdown
Black: `2H 3D 5S 9C KD` White: `2C 3H 4S 8C AH`
```



`Case2`: Black为散牌，White为同花

```markdown
Black: `2H 4S 4C 2D 4H` White: `2S 8S AS QS 3S`
```



`Case3`: Black为同花，White为散牌

```markdown
Black: `2H 3H 5H 9H KH` White: `2C 3H 4S 5C 6H`
```



`Case4`: 散牌的平局情况

```markdown
Black: `2H 3D 5S 9C KD` White: `2D 3H 5C 9S KH`
```



`Case5`: Back为两对，White为一对

```markdown
Black: `2C 3H 3S 6C 6H` White: `2C 2S 3C 6D KH`
```



`Case6`: Black为同花，White为同花顺

```markdown
Black: `2C KC 3C 5C 6C` White: `3D 5D 7D 4D 6D`
```



`Case7`: 同为对子的比较

```markdown
Black: `2C KD 2H 5C AS` White: `KS 5H 7D 4C KD`
```



`Case8`: 同为两对的比较

```markdown
Black: `2C KD 2H AC AS` White: `KS 7H 7D 4C KD`
```

