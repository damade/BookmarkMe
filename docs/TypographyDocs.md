This documentation maps the React Native typography (which follows the iOS Human Interface Guidelines convention) to the **Material 3 (M3)** type system.

Material 3 uses a more rigid "Role-based" system (Display, Headline, Title, Body, Label). Mapping them allows your app to maintain a consistent semantic structure while honoring your specific design values.

---

### Typography Mapping Overview

| RN Style      | M3 Role Mapping     | RN Size | M3 Default Size |
|---------------|---------------------|---------|-----------------|
| `largeTitle`  | **Display Small**   | 34      | 36              |
| `title1`      | **Headline Medium** | 28      | 28              |
| `title2`      | **Title Large**     | 22      | 22              |
| `title3`      | **Title Medium**    | 20      | 16              |
| `headline`    | **Title Small**     | 17      | 14              |
| `body`        | **Body Large**      | 17      | 16              |
| `callout`     | **Body Medium**     | 16      | 14              |
| `subheadline` | **Body Small**      | 15      | 12              |
| `footnote`    | **Label Large**     | 13      | 14              |
| `caption1`    | **Label Medium**    | 12      | 12              |
| `caption2`    | **Label Small**     | 11      | 11              |

**Note:** Add `Emphasized` suffix for the **Emphasized** variants.
For example; emphasized `title1` in React would be `headlineMediumEmphasized` in Material3


---

### Detailed Style Breakdown

#### 1. Display & Headlines (Hero Text)

Used for the most important text on the screen, like headers in a large dashboard or section titles.

* **Large Title (`Display Small`)**
* *Regular:* 34px / Weight 400 / LH 41
* *Emphasized:* 34px / Weight 700 / LH 41


* **Title 1 (`Headline Medium`)**
* *Regular:* 28px / Weight 400 / LH 34
* *Emphasized:* 28px / Weight 700 / LH 34



#### 2. Titles (Navigation & Sub-sections)

Used for app bars, list headers, and secondary headings.

* **Title 2 (`Title Large`)**
* *Regular:* 22px / Weight 400 / LH 28
* *Emphasized:* 22px / Weight 700 / LH 28


* **Title 3 (`Title Medium`)**
* *Regular:* 20px / Weight 400 / LH 25
* *Emphasized:* 20px / Weight 600 / LH 25


* **Headline (`Title Small`)**
* *Regular:* 17px / Weight 600 / LH 22



#### 3. Body (Main Content)

Used for long-form reading and primary user input.

* **Body (`Body Large`)**
* *Regular:* 17px / Weight 400 / LH 22
* *Emphasized:* 17px / Weight 600 / LH 22


* **Callout (`Body Medium`)**
* *Regular:* 16px / Weight 400 / LH 21
* *Emphasized:* 16px / Weight 600 / LH 21


* **Subheadline (`Body Small`)**
* *Regular:* 15px / Weight 400 / LH 20
* *Emphasized:* 15px / Weight 600 / LH 20



#### 4. Labels & Captions (Metadata)

Used for annotations, button text, and small context-clues.

* **Footnote (`Label Large`)**
* *Regular:* 13px / Weight 400 / LH 18


* **Caption 1 (`Label Medium`)**
* *Regular:* 12px / Weight 400 / LH 16


* **Caption 2 (`Label Small`)**
* *Regular:* 11px / Weight 400 / LH 13



---

### Implementation Implementation Note

In Material 3, **Emphasized** variants are usually handled by increasing the `fontWeight` of the base role rather than creating an entirely new role.

> **Important on Spacing:** Your typography uses negative `letterSpacing` for several styles (e.g., Title 2, Title 3, Body). Material 3 typically defaults to positive or zero tracking. Ensure your React Native `TextStyle` explicitly includes these negative values to maintain that "compact" look.

---