<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/export_dxf_title"
        android:textSize="24sp"
        android:layout_marginBottom="16dp" />

    <CheckBox
        android:id="@+id/exportGeometryCheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/export_geometry"
        android:checked="true" />

    <CheckBox
        android:id="@+id/exportDeformationsCheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/export_deformations" />

    <CheckBox
        android:id="@+id/exportStressesCheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/export_stresses" />

    <EditText
        android:id="@+id/fileNameEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/file_name"
        android:inputType="text"
        android:layout_marginTop="16dp" />

    <Button
        android:id="@+id/exportDxfButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/export"
        android:layout_marginTop="16dp" />

</LinearLayout>
