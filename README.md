# 🌈 GradientCardView

A customizable **MaterialCardView** with **gradient background support**:  
- Linear (horizontal, vertical, angled)  
- Radial  
- Sweep  

Easily add **beautiful gradients** to your cards with customizable colors, positions, and orientation.

---

## 📦 Installation

Add **JitPack** to your `settings.gradle` or `build.gradle`:

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    implementation 'com.github.ParithiAndroid:GradientCardView:1.0.0'
}

```

# Usage
## XML Examples

```

// 1. Horizontal Gradient
<com.parithidb.parithilibrary.GradientCardView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:gradientType="linear"
    app:gradientOrientation="horizontal"
    app:startColor="@color/purple_500"
    app:endColor="@color/teal_200"
    app:cardCornerRadius="16dp"
    app:cardElevation="8dp"/>

// 2. Vertical Gradient
<com.parithidb.parithilibrary.GradientCardView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:gradientType="linear"
    app:gradientOrientation="vertical"
    app:startColor="@color/red"
    app:endColor="@color/blue"
    app:cardCornerRadius="16dp"
    app:cardElevation="8dp"/>

// 3. Angled Linear Gradient (e.g., 45°)
<com.parithidb.parithilibrary.GradientCardView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:gradientType="linear"
    app:gradientOrientation="angle"
    app:gradientAngle="45"
    app:startColor="@color/purple_500"
    app:endColor="@color/teal_200"
    app:cardCornerRadius="16dp"
    app:cardElevation="8dp"/>

// 4. Radial Gradient
<com.parithidb.parithilibrary.GradientCardView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:gradientType="radial"
    app:startColor="@color/yellow"
    app:endColor="@color/black"
    app:startPercentage="0.5"
    app:cardCornerRadius="16dp"
    app:cardElevation="8dp"/>

// 5. Sweep Gradient
<com.parithidb.parithilibrary.GradientCardView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    app:gradientType="sweep"
    app:startColor="@color/green"
    app:endColor="@color/orange"
    app:cardCornerRadius="16dp"
    app:cardElevation="8dp"/>

```

## Kotlin Usage

You can also set gradients programmatically:

```
val cardView = findViewById<GradientCardView>(R.id.myCardView)

// Set linear horizontal gradient
cardView.setGradientColors(
    start = ContextCompat.getColor(this, R.color.purple_500),
    end = ContextCompat.getColor(this, R.color.teal_200)
)
cardView.setGradientOrientation(0) // 0 = horizontal, 1 = vertical, 2 = angle

// Set angled gradient (e.g., 60°)
cardView.setGradientAngle(60)

// Switch to radial gradient
cardView.setGradientType(1) // 0 = linear, 1 = radial, 2 = sweep

// Switch to sweep gradient
cardView.setGradientType(2)

```

## ⚙️ Supported Attributes

| Attribute             | Type   | Description                                             |
|-----------------------|--------|---------------------------------------------------------|
| `startColor`          | color  | Gradient start color                                   |
| `endColor`            | color  | Gradient end color                                     |
| `gradientType`        | enum   | `linear`, `radial`, `sweep`                            |
| `gradientOrientation` | enum   | `horizontal`, `vertical`, `angle` (only for linear)    |
| `gradientAngle`       | int    | Custom angle (0–360°) when orientation = `angle`       |
| `startPercentage`     | float  | Position for gradient center (used in radial gradients) |


License
MIT License
